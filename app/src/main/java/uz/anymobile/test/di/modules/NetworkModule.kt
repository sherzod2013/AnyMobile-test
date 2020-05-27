package uz.anymobile.test.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import uz.anymobile.test.di.scopes.ActivityScope
import uz.anymobile.test.utils.Constants
import javax.inject.Singleton

@Module
class NetworkModule {

    @ActivityScope
    @Provides
    fun okhtppLoggingInterceptor() = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @ActivityScope
    @Provides
    fun okhttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
            .addInterceptor {
                val original = it.request()
                val originalHttpUrl = original.url

                val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("uuid", Constants.UUID)
                        .addQueryParameter("secret", Constants.SECRET)
                        .build()
                val requestBuilder = original.newBuilder()
                        .url(url)
                val request = requestBuilder.build()
                it.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .build()
}
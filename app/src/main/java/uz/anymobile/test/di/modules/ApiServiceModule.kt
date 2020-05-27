package uz.anymobile.test.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.anymobile.test.di.scopes.ActivityScope
import uz.anymobile.test.network.AdService
import uz.anymobile.test.utils.Constants
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiServiceModule {

    @ActivityScope
    @Provides
    fun provideService(client: Retrofit): AdService {
        return client.create(AdService::class.java)
    }

    @ActivityScope
    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @ActivityScope
    @Provides
    fun providesRetrofitClient(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .build()
    }
}
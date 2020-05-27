package uz.anymobile.test.di.modules

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.anymobile.test.database.AppDatabase
import uz.anymobile.test.database.entity.Item
import uz.anymobile.test.database.entity.User
import uz.anymobile.test.di.scopes.ActivityScope
import uz.anymobile.test.network.AdService
import uz.anymobile.test.utils.Constants
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class DtabaseModule {

    lateinit var trainDB: AppDatabase

    @ActivityScope
    @Provides
    fun provideDb(context: Context): AppDatabase {
        trainDB = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my-database"
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadScheduledExecutor().execute(Runnable {
                        trainDB.userDao().insertAll(User.populateData())
                        trainDB.itemDao().insertAll(Item.populateData())
                    })
                }
            })
            .build()
        return trainDB
    }
}
package uz.anymobile.test.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import uz.anymobile.test.database.dao.ItemDao
import uz.anymobile.test.database.dao.UserDao
import uz.anymobile.test.database.entity.Item
import uz.anymobile.test.database.entity.User
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Room
import androidx.annotation.NonNull
import java.util.concurrent.Executors


@Database(entities = [User::class, Item::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    companion object{
        private var INSTANCE: AppDatabase? = null
    }
    abstract fun userDao(): UserDao
    abstract fun itemDao(): ItemDao


    fun getInstance(context: Context): AppDatabase? {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context)
        }
        return INSTANCE
    }

    private fun buildDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my-database"
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadScheduledExecutor().execute(Runnable {
                        getInstance(context)!!.userDao().insertAll(User.populateData())
                        getInstance(context)!!.itemDao().insertAll(Item.populateData())
                    })
                }
            })
            .build()
    }

}
package uz.anymobile.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.anymobile.test.database.dao.ItemDao
import uz.anymobile.test.database.dao.UserDao
import uz.anymobile.test.database.entity.Item
import uz.anymobile.test.database.entity.User


@Database(entities = [User::class, Item::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun itemDao(): ItemDao
}
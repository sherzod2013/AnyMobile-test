package uz.anymobile.test.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.anymobile.test.database.entity.Item


@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): List<Item>

    @Query("SELECT * FROM item WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Item>

    @Query("SELECT * FROM item WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Item

    @Insert
    fun insertAll(item: List<Item>)

    @Delete
    fun delete(item: Item)
}
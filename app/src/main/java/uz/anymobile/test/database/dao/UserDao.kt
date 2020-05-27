package uz.anymobile.test.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.anymobile.test.database.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): User

    @Query("SELECT * FROM user ORDER BY uid DESC")
    fun getAllUsersPaged(): DataSource.Factory<Int, User>

    @Insert
    fun insertAll(users: List<User>)

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}
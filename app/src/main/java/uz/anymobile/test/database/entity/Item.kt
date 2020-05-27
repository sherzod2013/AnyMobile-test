package uz.anymobile.test.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val firstName: String?
) {

    companion object {
        fun populateData(): List<Item> {
            val data = ArrayList<Item>()
            for (i in 1..100){
                data.add(Item(i, "Item $i"))
            }
            return data
        }
    }
}
package uz.anymobile.test.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @ColumnInfo(name = "name") val firstName: String?
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
    companion object {
        fun populateData(): List<Item> {
            val data = ArrayList<Item>()
            for (i in 1..100){
                data.add(Item("Item $i"))
            }
            return data
        }
    }
}
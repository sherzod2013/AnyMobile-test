package uz.anymobile.test.ui.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.anymobile.test.R
import uz.anymobile.test.database.entity.Item

class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
) {

    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private val idView = itemView.findViewById<TextView>(R.id.id)
    var item: Item? = null

    fun bindTo(item: Item?) {
        this.item = item
        if (item != null) {
            nameView.text = "Item Name: " + item.firstName
            idView.text = "Item UID: " + item.uid.toString()
        }
    }
}
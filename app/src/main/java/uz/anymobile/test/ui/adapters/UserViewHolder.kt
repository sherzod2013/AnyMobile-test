package uz.anymobile.test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.anymobile.test.R
import uz.anymobile.test.database.entity.User

class UserViewHolder (parent : ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)) {

    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private val idView = itemView.findViewById<TextView>(R.id.id)
    var cheese : User? = null

    fun bindTo(user : User?) {
        this.cheese = user
        if(user != null) {
            nameView.text = "Name: " + user.firstName
            idView.text = "ID: " + user.uid.toString()
        }
    }
}
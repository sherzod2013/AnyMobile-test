package uz.anymobile.test.ui.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import uz.anymobile.test.database.entity.User

class UsersAdapter() :
    PagedListAdapter<User, UserViewHolder>(DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User? = getItem(position)
        holder.bindTo(user)
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                oldConcert: User,
                newConcert: User
            ) = oldConcert.uid == newConcert.uid

            override fun areContentsTheSame(
                oldConcert: User,
                newConcert: User
            ) = oldConcert == newConcert
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(parent)
}
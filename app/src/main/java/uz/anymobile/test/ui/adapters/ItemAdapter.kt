package uz.anymobile.test.ui.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import uz.anymobile.test.database.entity.Item
import uz.anymobile.test.ui.viewholders.ItemViewHolder

class ItemAdapter() :
    PagedListAdapter<Item, ItemViewHolder>(DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item? = getItem(position)
        holder.bindTo(item)
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(
                oldConcert: Item,
                newConcert: Item
            ) = oldConcert.uid == newConcert.uid

            override fun areContentsTheSame(
                oldConcert: Item,
                newConcert: Item
            ) = oldConcert == newConcert
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(parent)
}
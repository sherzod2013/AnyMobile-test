package uz.anymobile.test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.anymobile.test.R
import uz.anymobile.test.network.pojo.AdResponse
import uz.anymobile.test.ui.viewholders.AddsViewHolder

class AddsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: List<AdResponse> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AddsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_adds, parent, false)
        )

    }

    fun setData(data: List<AdResponse>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AddsViewHolder).bindView(data[position])
    }

}
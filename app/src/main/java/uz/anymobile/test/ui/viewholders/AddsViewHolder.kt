package uz.anymobile.test.ui.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.anymobile.test.R
import uz.anymobile.test.network.pojo.AdResponse

class AddsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(ad: AdResponse) {
        val imgView: ImageView = itemView.findViewById(R.id.img)
        val textView: TextView = itemView.findViewById(R.id.ad_name)
        textView.text = ad.name
        Glide
            .with(itemView.context)
            .load(ad.files[0].url)
            .centerCrop()
            .into(imgView)

    }
}
package uz.anymobile.test.network.pojo

import com.google.gson.annotations.SerializedName

data class AdModel(
    @SerializedName("zone") val data: List<AdResponse>,
    @SerializedName("ad_mob") val isAdMode: Boolean
)
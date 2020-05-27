package uz.anymobile.test.network.pojo

data class AdResponse(
    val name: String,
    val type: String,
    val url: String,
    val priority: Int,
    val files: ArrayList<AdResponse>
)
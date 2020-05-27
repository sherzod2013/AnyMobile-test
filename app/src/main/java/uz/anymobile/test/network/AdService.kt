package uz.anymobile.test.network

import io.reactivex.Observable
import retrofit2.http.GET
import uz.anymobile.test.network.pojo.AdModel

interface AdService {

    @GET("60")
    fun discoverAdds(): Observable<AdModel>
}

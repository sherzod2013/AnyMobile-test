package uz.anymobile.test.ui.fragments.network.mvp.view

import android.view.View
import io.reactivex.Observable
import uz.anymobile.test.network.pojo.AdModel

interface NetworkView {
    val view: View

    fun setLoading(boolean: Boolean)

    fun setData(adds: AdModel)

    fun showError(error: String)

    val refreshClick: Observable<Any>
}
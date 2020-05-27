package uz.anymobile.test.ui.fragments.network.mvp.view

import android.content.Context
import android.view.View
import androidx.core.view.isVisible
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.error_layout.view.*
import kotlinx.android.synthetic.main.fragment_network.view.*
import uz.anymobile.test.R
import uz.anymobile.test.network.pojo.AdModel
import uz.anymobile.test.ui.base.BaseView

class NetworkViewImpl  (context: Context) : BaseView(context), NetworkView {

    override val view = this
    init {
        inflate(R.layout.fragment_network)
    }

    override fun setLoading(boolean: Boolean) {
        progress_bar.isVisible = boolean
    }

    override fun setData(adds: AdModel) {
        setLoading(false)
        error_state.visibility = View.GONE

    }

    override fun showError(error: String) {
        setLoading(false)
        error_state.visibility = View.VISIBLE
    }

    override val refreshClick: Observable<Any> = RxView.clicks(retry_on_error)
}
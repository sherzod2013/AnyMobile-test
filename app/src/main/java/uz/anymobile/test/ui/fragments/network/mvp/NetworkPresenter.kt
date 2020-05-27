package uz.anymobile.test.ui.fragments.network.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.fragments.network.mvp.view.NetworkView

class NetworkPresenter(
    private val model: NetworkModel, private val view: NetworkView
) : BasePresenter() {

    override fun onCreate() {
        startLoad()
        compositeDisposable.add(
            refreshClick()
        )
    }

    private fun refreshClick() = view.refreshClick.subscribe {
        startLoad()
    }

    private fun startLoad() {
        view.setLoading(true)
        compositeDisposable.add(
            model.service.discoverAdds()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    view.setData(it)
                    view.setLoading(false)
                }, {
                    view.showError(it.toString())
                })
        )
    }
}
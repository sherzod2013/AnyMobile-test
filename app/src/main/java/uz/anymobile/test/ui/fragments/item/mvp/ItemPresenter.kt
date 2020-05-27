package uz.anymobile.test.ui.fragments.item.mvp

import androidx.fragment.app.Fragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.fragments.item.mvp.view.ItemView

class ItemPresenter(
    private val model: ItemModel, private val view: ItemView,
    private val fragment: Fragment
) : BasePresenter() {

    override fun onCreate() {
        view.initRecycler()
        compositeDisposable.add(
            model.viewModel.itemsList
                .subscribe(view.adapter::submitList)
        )
        compositeDisposable.add(addClick())
        compositeDisposable.add(addData())
    }

    private fun addClick() = view.addFLBClick.subscribe {
        view.showInsertDialog()
    }

    private fun addData() = view.addClick.observeOn(Schedulers.io()).map {
        model.database.itemDao().insert(it)
    }.subscribeOn(AndroidSchedulers.mainThread())
        .subscribe {
            view.navigateToFirst()
        }
}
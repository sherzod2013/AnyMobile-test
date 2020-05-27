package uz.anymobile.test.ui.fragments.user.mvp

import androidx.fragment.app.Fragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.fragments.user.mvp.UserModel
import uz.anymobile.test.ui.fragments.user.mvp.view.UserView

class UserPresenter(
    private val model: UserModel, private val view: UserView,
    private val fragment: Fragment
) : BasePresenter() {

    override fun onCreate() {
        view.initRecycler()
        compositeDisposable.add(
            model.viewModel.userList
                .subscribe(view.adapter::submitList)
        )
        compositeDisposable.add(addClick())
        compositeDisposable.add(addData())
    }

    private fun addClick() = view.addFLBClick.subscribe {
        view.showInsertDialog()
    }

    private fun addData() = view.addClick.observeOn(Schedulers.io()).map {
        model.database.userDao().insert(it)
    }.subscribeOn(AndroidSchedulers.mainThread())
        .subscribe {
            view.navigateToFirst()
        }
}
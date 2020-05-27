package uz.anymobile.test.ui.base


abstract class BasePresenter {
    val compositeDisposable = io.reactivex.disposables.CompositeDisposable()

    abstract fun onCreate()

    fun onDestroy() { compositeDisposable.clear()}

}
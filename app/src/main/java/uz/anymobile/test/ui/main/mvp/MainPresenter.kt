package uz.anymobile.test.ui.main.mvp

import android.app.Activity
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.main.mvp.view.MainView

class MainPresenter (private val model: MainModel, private val view: MainView,
                     private val activity: Activity
) : BasePresenter() {
    override fun onCreate() {

    }
}
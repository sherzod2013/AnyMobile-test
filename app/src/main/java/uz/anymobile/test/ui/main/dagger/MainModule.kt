package uz.anymobile.test.ui.main.dagger

import android.app.Activity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import uz.anymobile.test.network.AdService
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.main.mvp.MainModel
import uz.anymobile.test.ui.main.mvp.MainPresenter
import uz.anymobile.test.ui.main.mvp.view.MainView
import uz.anymobile.test.ui.main.mvp.view.MainViewImpl

@Module
class MainModule(val activity: Activity) {

    @Provides
    @MainScope
    fun mainView(): MainView = MainViewImpl(activity)

    @Provides
    @MainScope
    fun mainModel(service: AdService) =
            MainModel(activity, service)

    @Provides
    @MainScope
    fun mainPresenter(model: MainModel, view: MainView):
            BasePresenter = MainPresenter(model, view, activity)
}
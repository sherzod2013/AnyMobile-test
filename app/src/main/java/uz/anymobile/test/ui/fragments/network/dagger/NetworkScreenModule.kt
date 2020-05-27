package uz.anymobile.test.ui.fragments.network.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import uz.anymobile.test.network.AdService
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.fragments.network.mvp.NetworkModel
import uz.anymobile.test.ui.fragments.network.mvp.NetworkPresenter
import uz.anymobile.test.ui.fragments.network.mvp.view.NetworkView
import uz.anymobile.test.ui.fragments.network.mvp.view.NetworkViewImpl

@Module
class NetworkScreenModule  (val fragment: Fragment) {

    @Provides
    @NetworkScreenScope
    fun networkView(): NetworkView = NetworkViewImpl(fragment.requireContext())

    @Provides
    @NetworkScreenScope
    fun networkModel(service: AdService) =
        NetworkModel(fragment,service)

    @Provides
    @NetworkScreenScope
    fun networkPresenter(model: NetworkModel, view: NetworkView):
            BasePresenter = NetworkPresenter(model, view)
}
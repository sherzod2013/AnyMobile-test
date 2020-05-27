package uz.anymobile.test.ui.fragments.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.anymobile.test.App
import uz.anymobile.test.ui.base.BaseFragment
import uz.anymobile.test.ui.fragments.network.dagger.DaggerNetworkScreenComponent
import uz.anymobile.test.ui.fragments.network.dagger.NetworkScreenModule
import uz.anymobile.test.ui.fragments.network.mvp.NetworkModel
import uz.anymobile.test.ui.fragments.network.mvp.view.NetworkView
import javax.inject.Inject

class NetworkFragment :BaseFragment(){

    lateinit var networkView: NetworkView
        @Inject set

    lateinit var networkModel: NetworkModel
        @Inject set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerNetworkScreenComponent.builder()
            .appComponent(App.get(requireContext()).component())
            .networkScreenModule(NetworkScreenModule(this))
            .build().inject(this)
        return networkView.view
    }
}
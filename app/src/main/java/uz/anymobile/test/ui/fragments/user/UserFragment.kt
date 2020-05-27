package uz.anymobile.test.ui.fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.anymobile.test.App
import uz.anymobile.test.ui.base.BaseFragment
import uz.anymobile.test.ui.fragments.user.dagger.DaggerUserComponent
import uz.anymobile.test.ui.fragments.user.dagger.UserModule
import uz.anymobile.test.ui.fragments.user.mvp.UserModel
import uz.anymobile.test.ui.fragments.user.mvp.view.UserView
import javax.inject.Inject

class UserFragment : BaseFragment() {

    lateinit var userView: UserView
        @Inject set

    lateinit var userModel: UserModel
        @Inject set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerUserComponent.builder()
            .appComponent(App.get(requireContext()).component())
            .userModule(UserModule(this))
            .build().inject(this)
        return userView.view
    }
}
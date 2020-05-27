package uz.anymobile.test.ui.fragments.user.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import uz.anymobile.test.database.AppDatabase
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.fragments.user.mvp.UserModel
import uz.anymobile.test.ui.fragments.user.mvp.UserPresenter
import uz.anymobile.test.ui.fragments.user.mvp.view.UserView
import uz.anymobile.test.ui.fragments.user.mvp.view.UserViewImpl

@Module
class UserModule (val fragment: Fragment) {

    @Provides
    @UserScope
    fun userView(): UserView = UserViewImpl(fragment.requireContext())

    @Provides
    @UserScope
    fun userModel(database: AppDatabase) =
        UserModel(fragment,database)

    @Provides
    @UserScope
    fun mainPresenter(model: UserModel, view: UserView):
            BasePresenter = UserPresenter(model, view, fragment)
}
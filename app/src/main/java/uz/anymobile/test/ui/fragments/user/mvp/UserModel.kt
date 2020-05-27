package uz.anymobile.test.ui.fragments.user.mvp

import androidx.fragment.app.Fragment
import uz.anymobile.test.database.AppDatabase
import uz.anymobile.test.ui.adapters.UserViewModel

class UserModel(private val fragment: Fragment, val database: AppDatabase) {
    val viewModel: UserViewModel = UserViewModel(database.userDao())
}

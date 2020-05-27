package uz.anymobile.test.ui.fragments.user.mvp.view

import android.view.View
import io.reactivex.Observable
import uz.anymobile.test.database.entity.User
import uz.anymobile.test.ui.adapters.UsersAdapter

interface UserView {
    val view: View
    val adapter : UsersAdapter

    /**
     * Observable from add button clicks
     */
    val addFLBClick: Observable<Any>

    val addClick: Observable<User>

    fun initRecycler()

    fun showInsertDialog()

    fun navigateToFirst()
}
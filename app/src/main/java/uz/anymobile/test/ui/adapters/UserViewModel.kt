package uz.anymobile.test.ui.adapters

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import androidx.paging.toLiveData
import io.reactivex.Observable
import uz.anymobile.test.database.dao.UserDao
import uz.anymobile.test.database.entity.User

class UserViewModel(userDao: UserDao) : ViewModel() {
    val userList: Observable<PagedList<User>> =
        RxPagedListBuilder(
            userDao.getAllUsersPaged(), 10).buildObservable()
}
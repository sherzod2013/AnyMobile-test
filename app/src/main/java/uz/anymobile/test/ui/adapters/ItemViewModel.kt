package uz.anymobile.test.ui.adapters

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import io.reactivex.Observable
import uz.anymobile.test.database.dao.ItemDao
import uz.anymobile.test.database.entity.Item

class ItemViewModel(itemDao: ItemDao) : ViewModel() {
    val itemsList: Observable<PagedList<Item>> =
        RxPagedListBuilder(
            itemDao.getAllItemsPaged(), 10
        ).buildObservable()
}
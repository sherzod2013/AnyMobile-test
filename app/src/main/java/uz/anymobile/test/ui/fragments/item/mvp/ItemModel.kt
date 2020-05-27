package uz.anymobile.test.ui.fragments.item.mvp

import androidx.fragment.app.Fragment
import uz.anymobile.test.database.AppDatabase
import uz.anymobile.test.ui.adapters.ItemViewModel

class ItemModel(private val fragment: Fragment, val database: AppDatabase) {
    val viewModel: ItemViewModel = ItemViewModel(database.itemDao())
}

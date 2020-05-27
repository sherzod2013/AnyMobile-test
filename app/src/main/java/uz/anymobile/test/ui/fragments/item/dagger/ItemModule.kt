package uz.anymobile.test.ui.fragments.item.dagger

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import uz.anymobile.test.database.AppDatabase
import uz.anymobile.test.ui.base.BasePresenter
import uz.anymobile.test.ui.fragments.item.mvp.ItemModel
import uz.anymobile.test.ui.fragments.item.mvp.ItemPresenter
import uz.anymobile.test.ui.fragments.item.mvp.view.ItemView
import uz.anymobile.test.ui.fragments.item.mvp.view.ItemViewImpl

@Module
class ItemModule(val fragment: Fragment) {

    @Provides
    @ItemSocope
    fun itemView(): ItemView = ItemViewImpl(fragment.requireContext())

    @Provides
    @ItemSocope
    fun itemModel(database: AppDatabase) =
        ItemModel(fragment, database)

    @Provides
    @ItemSocope
    fun mainPresenter(model: ItemModel, view: ItemView):
            BasePresenter = ItemPresenter(model, view, fragment)
}
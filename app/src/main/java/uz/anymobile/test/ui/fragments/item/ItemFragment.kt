package uz.anymobile.test.ui.fragments.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.anymobile.test.App
import uz.anymobile.test.ui.base.BaseFragment
import uz.anymobile.test.ui.fragments.item.dagger.DaggerItemComponent
import uz.anymobile.test.ui.fragments.item.dagger.ItemModule
import uz.anymobile.test.ui.fragments.item.mvp.ItemModel
import uz.anymobile.test.ui.fragments.item.mvp.view.ItemView
import javax.inject.Inject

class ItemFragment : BaseFragment() {

    lateinit var itemView: ItemView
        @Inject set

    lateinit var itemModel: ItemModel
        @Inject set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerItemComponent.builder()
            .appComponent(App.get(requireContext()).component())
            .itemModule(ItemModule(this))
            .build().inject(this)
        return itemView.view
    }
}
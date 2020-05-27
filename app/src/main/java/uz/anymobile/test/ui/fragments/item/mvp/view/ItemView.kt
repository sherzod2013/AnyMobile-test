package uz.anymobile.test.ui.fragments.item.mvp.view

import android.view.View
import io.reactivex.Observable
import uz.anymobile.test.database.entity.Item
import uz.anymobile.test.ui.adapters.ItemAdapter

interface ItemView {
    val view: View
    val adapter: ItemAdapter

    /**
     * Observable from add button clicks
     */
    val addFLBClick: Observable<Any>

    val addClick: Observable<Item>

    fun initRecycler()

    fun showInsertDialog()

    fun navigateToFirst()
}
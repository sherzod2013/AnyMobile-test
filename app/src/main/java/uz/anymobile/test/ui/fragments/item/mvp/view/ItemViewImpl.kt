package uz.anymobile.test.ui.fragments.item.mvp.view

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.dialog_add.view.*
import kotlinx.android.synthetic.main.fragment_item.view.*
import uz.anymobile.test.R
import uz.anymobile.test.database.entity.Item
import uz.anymobile.test.ui.adapters.ItemAdapter
import uz.anymobile.test.ui.base.BaseView
import uz.anymobile.test.utils.MyDividerItemDecoration

class ItemViewImpl(context: Context) : BaseView(context), ItemView {

    override val view = this

    init {
        inflate(R.layout.fragment_item)
    }

    override val adapter = ItemAdapter()
    override val addFLBClick: Observable<Any> = RxView.clicks(floatingActionButton_item)
    override val addClick: BehaviorSubject<Item> = BehaviorSubject.create()

    override fun initRecycler() {
        recycler_item.adapter = adapter
        recycler_item.layoutManager = LinearLayoutManager(context)
        recycler_item.setHasFixedSize(true)
        recycler_item.itemAnimator = DefaultItemAnimator()
        recycler_item.addItemDecoration(
            MyDividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL,
                16
            )
        )
    }

    override fun showInsertDialog() {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle("Add Item Form")
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.add.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
            //get text from EditTexts of custom layout
            val name = mDialogView.name_tv.text.toString()
            val item = Item(name)
            addClick.onNext(item)
        }
        //cancel button click of custom layout
        mDialogView.cancel.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

    override fun navigateToFirst() {
        recycler_item.smoothScrollToPosition(0);
    }
}
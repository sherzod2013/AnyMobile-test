package uz.anymobile.test.ui.fragments.user.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.dialog_add.view.*
import kotlinx.android.synthetic.main.fragment_user.view.*
import uz.anymobile.test.R
import uz.anymobile.test.database.entity.User
import uz.anymobile.test.ui.adapters.UsersAdapter
import uz.anymobile.test.ui.base.BaseView
import uz.anymobile.test.ui.fragments.user.mvp.view.UserView
import uz.anymobile.test.utils.MyDividerItemDecoration

class UserViewImpl (context: Context) : BaseView(context), UserView {

    override val view = this

    init {
        inflate(R.layout.fragment_user)
    }

    override val adapter = UsersAdapter()
    override val addFLBClick: Observable<Any> = RxView.clicks(floatingActionButton)
    override val addClick: BehaviorSubject<User> = BehaviorSubject.create()

    override fun initRecycler() {
        recycler.adapter =adapter
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.addItemDecoration(
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
            .setTitle("Add User Form")
        //show dialog
        val  mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.add.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
            //get text from EditTexts of custom layout
            val name = mDialogView.name_tv.text.toString()
            val user = User(name)
            addClick.onNext(user)
        }
        //cancel button click of custom layout
        mDialogView.cancel.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

    override fun navigateToFirst() {
        recycler.smoothScrollToPosition(0);
    }
}
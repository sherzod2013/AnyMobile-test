package uz.anymobile.test.ui.base

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes

open class BaseView(context: Context) : FrameLayout(context) {

    fun inflate(@LayoutRes layoutId: Int) {
        View.inflate(context, layoutId, this)
    }
}
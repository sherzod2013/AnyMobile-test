package uz.anymobile.test.ui.main.mvp.view

import android.view.View
import androidx.fragment.app.FragmentManager

interface MainView {
    val view: View

    fun initViewPager(fragmentManager: FragmentManager)
}
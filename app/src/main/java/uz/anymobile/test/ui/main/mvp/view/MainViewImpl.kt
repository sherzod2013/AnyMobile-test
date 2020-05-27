package uz.anymobile.test.ui.main.mvp.view

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import uz.anymobile.test.R
import uz.anymobile.test.ui.adapters.PagerAdapter
import uz.anymobile.test.ui.base.BaseView


class MainViewImpl(context: Context) : BaseView(context), MainView {

    override val view = this

    init {
        inflate(R.layout.activity_main)

    }

    override fun initViewPager(fragmentManager: FragmentManager) {
        val adapter = PagerAdapter(fragmentManager)
        viewPager.adapter = adapter
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }
}
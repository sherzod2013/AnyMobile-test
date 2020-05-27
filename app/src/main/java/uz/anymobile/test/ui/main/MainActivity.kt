package uz.anymobile.test.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import uz.anymobile.test.App
import uz.anymobile.test.R
import uz.anymobile.test.ui.adapters.PagerAdapter
import uz.anymobile.test.ui.base.BaseActivity
import uz.anymobile.test.ui.main.dagger.DaggerMainComponent
import uz.anymobile.test.ui.main.dagger.MainModule
import uz.anymobile.test.ui.main.mvp.MainModel
import uz.anymobile.test.ui.main.mvp.view.MainView
import javax.inject.Inject

class MainActivity : BaseActivity() {
    lateinit var mainView: MainView
        @Inject set

    lateinit var mainModel: MainModel
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainComponent.builder()
            .appComponent(App.get(this).component())
            .mainModule(MainModule(this))
            .build().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(mainView.view)
        supportActionBar?.hide()
        mainView.initViewPager(supportFragmentManager)
    }
}
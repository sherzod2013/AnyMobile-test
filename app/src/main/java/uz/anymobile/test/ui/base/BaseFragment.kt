package uz.anymobile.test.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
    lateinit var presenter: BasePresenter
        @Inject set

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
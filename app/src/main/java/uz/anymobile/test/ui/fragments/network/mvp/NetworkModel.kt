package uz.anymobile.test.ui.fragments.network.mvp

import androidx.fragment.app.Fragment
import uz.anymobile.test.database.AppDatabase
import uz.anymobile.test.network.AdService
import uz.anymobile.test.ui.adapters.UserViewModel

class NetworkModel (private val fragment: Fragment, val service: AdService) {
    fun adds() = service.discoverMovies()
}
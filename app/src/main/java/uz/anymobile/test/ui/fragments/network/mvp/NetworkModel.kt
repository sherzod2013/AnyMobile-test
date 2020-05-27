package uz.anymobile.test.ui.fragments.network.mvp

import androidx.fragment.app.Fragment
import uz.anymobile.test.network.AdService

class NetworkModel (private val fragment: Fragment, val service: AdService) {
    fun adds() = service.discoverAdds()
}
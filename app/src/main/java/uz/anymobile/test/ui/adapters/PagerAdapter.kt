package uz.anymobile.test.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.anymobile.test.ui.fragments.item.ItemFragment
import uz.anymobile.test.ui.fragments.network.NetworkFragment
import uz.anymobile.test.ui.fragments.user.UserFragment

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 3

    override fun getItem(i: Int): Fragment {
        return when(i){
            0 -> UserFragment()
            1 -> NetworkFragment()
            2 -> ItemFragment()
            else -> UserFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        if(position == 0) return "One"
        if(position == 1) return "Two"
        if(position == 2) return "Three"
        return "OBJECT ${(position + 1)}"
    }
}
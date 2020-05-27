package uz.anymobile.test.ui.fragments.item.dagger

import dagger.Component
import uz.anymobile.test.di.AppComponent
import uz.anymobile.test.ui.fragments.item.ItemFragment

@ItemSocope
@Component(modules = [ItemModule::class], dependencies = [AppComponent::class])
interface ItemComponent {
    fun inject(fragment: ItemFragment)
}
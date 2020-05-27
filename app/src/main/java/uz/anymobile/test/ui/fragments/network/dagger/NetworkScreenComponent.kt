package uz.anymobile.test.ui.fragments.network.dagger

import dagger.Component
import uz.anymobile.test.di.AppComponent
import uz.anymobile.test.ui.fragments.network.NetworkFragment

@NetworkScreenScope
@Component(modules = [NetworkScreenModule::class], dependencies = [AppComponent::class])
interface NetworkScreenComponent {
    fun inject(fragment: NetworkFragment)
}
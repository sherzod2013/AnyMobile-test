package uz.anymobile.test.ui.main.dagger

import dagger.Component
import uz.anymobile.test.di.AppComponent
import uz.anymobile.test.ui.main.MainActivity

@MainScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}
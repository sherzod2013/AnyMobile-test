package uz.anymobile.test.ui.fragments.user.dagger

import dagger.Component
import uz.anymobile.test.di.AppComponent
import uz.anymobile.test.ui.fragments.user.UserFragment

@UserScope
@Component(modules = [UserModule::class], dependencies = [AppComponent::class])
interface UserComponent {
    fun inject(fragment: UserFragment)
}
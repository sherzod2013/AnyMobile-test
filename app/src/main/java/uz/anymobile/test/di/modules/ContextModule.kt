package uz.anymobile.test.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import uz.anymobile.test.di.scopes.ActivityScope

@Module
class ContextModule(val context: Context) {

    @Provides
    @ActivityScope
    fun context() = context
}
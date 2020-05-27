package uz.anymobile.test.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import uz.anymobile.test.di.scopes.ActivityScope
import uz.anymobile.test.utils.Constants
import javax.inject.Named
import javax.inject.Singleton

@Module
class ContextModule(val context: Context) {

    @Provides
    @ActivityScope
    fun context() = context

}
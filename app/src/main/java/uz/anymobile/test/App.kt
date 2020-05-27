package uz.anymobile.test

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import uz.anymobile.test.di.AppComponent
import uz.anymobile.test.di.DaggerAppComponent
import uz.anymobile.test.di.modules.ContextModule


class App : MultiDexApplication() {
    private var appComponent: AppComponent? = null

    fun component(): AppComponent {
        return appComponent!!
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()

    }
    companion object {
        fun get(activity: Context): App {
            return activity.applicationContext as App
        }
    }

}
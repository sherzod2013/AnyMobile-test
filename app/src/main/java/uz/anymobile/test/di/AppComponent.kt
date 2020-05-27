package uz.anymobile.test.di

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import uz.anymobile.test.database.AppDatabase
import uz.anymobile.test.di.modules.ApiServiceModule
import uz.anymobile.test.di.modules.ContextModule
import uz.anymobile.test.di.modules.DtabaseModule
import uz.anymobile.test.di.scopes.ActivityScope
import uz.anymobile.test.network.AdService
import javax.inject.Singleton

@ActivityScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ContextModule::class,
        ApiServiceModule::class,
        DtabaseModule::class
    ]
)
interface AppComponent {
    val adService: AdService
    val database: AppDatabase
}
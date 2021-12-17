package hu.kocsisgeri.bitraptors

import android.app.Application
import hu.kocsisgeri.bitraptors.domain.di.dataModule
import hu.kocsisgeri.bitraptors.domain.di.domainModule
import hu.kocsisgeri.bitraptors.domain.util.CrashReportingTree
import hu.kocsisgeri.bitraptors.ui.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import timber.log.Timber

open class MyApplication : Application() {
    internal lateinit var koinApplication: KoinApplication

    override fun onCreate() {
        super.onCreate()

        startKoin()
        initLogging()
    }

    open fun startKoin() {
        koinApplication = org.koin.core.context.startKoin {
            androidContext(this@MyApplication)
            modules(koinModules)
        }
    }

    open fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    companion object {
        internal val koinModules = listOf(
            appModule,
            domainModule,
            dataModule,
        )
    }
}
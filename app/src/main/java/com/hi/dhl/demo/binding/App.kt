package com.hi.dhl.demo.binding

import android.app.Application
import com.hi.dhl.demo.binding.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            AndroidLogger(Level.DEBUG)
            androidContext(this@App)
            loadKoinModules(appModules)
        }
    }
}
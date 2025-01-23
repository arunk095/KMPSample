package org.akstudios.kmpsample.app
import android.app.Application
import org.akstudios.kmpsample.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

/**
 * Created by Arun Kumar on 09/01/25.
 */
class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@SampleApplication)
        }
    }
}
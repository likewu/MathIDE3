package cn.leafcolor.mathide

import android.app.Application
import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.blacksquircle.ui.core.logger.AndroidTree
import com.blacksquircle.ui.core.storage.keyvalue.SettingsManager
import com.blacksquircle.ui.core.theme.Theme
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class SquircleApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun attachBaseContext(base: Context) {
        val settingsManager = SettingsManager(base)
        Theme.of(settingsManager.theme).apply()
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(AndroidTree())
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}
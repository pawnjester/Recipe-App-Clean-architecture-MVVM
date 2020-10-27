import android.app.Application
import net.danlew.android.joda.JodaTimeAndroid

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        JodaTimeAndroid.init(this)
    }
}
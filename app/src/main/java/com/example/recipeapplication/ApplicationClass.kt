class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        JodaTimeAndroid.init(this)
    }
}
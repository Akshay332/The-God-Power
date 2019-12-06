package com.goddess.base.utils

import android.app.Application

/**
 * Created by ShrayChona on 03-10-2018.
 */
class ApplicationGlobal : Application() {

    companion object {
        var accessToken: String = ""
        var deviceLocale: Int = 2
//        var deviceLocale: String = ""
    }

    override fun onCreate() {
        super.onCreate()

        // get device locale
//        deviceLocale = Locale.getDefault().language

        // get session id
//        accessToken = UserPrefsManager(this).accessToken
//        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7ImlkIjoiNWNhZjExOTdiMzU5ZDA3MTA4YWI2MmFiIiwicm9sZSI6InVzZXIifSwiZXhwIjoxNTU1MTQyNzI2ODE5LCJpYXQiOjE1NTUxMzkxMjZ9.GyuOSG9ptIqNRQfsUF6KXVcDVr2sb47wZWTL5h8jXjo"
    }
}
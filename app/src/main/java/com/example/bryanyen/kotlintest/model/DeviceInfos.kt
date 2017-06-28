package com.example.bryanyen.kotlintest.model

/**
 * Created by randyhsu on 2014/7/2.
 */
class DeviceInfos {
    /* Always used in "android" */
    var platformType = "android"
    var platformVersion: String? = null
        private set
    var appVersion: String? = null
    var language: String? = null
    var locale: String? = null
    var manifacture: String? = null
    var model: String? = null
    var imei: String? = null

    fun setPlatformVersionNum(mPlatformVersionNum: String) {
        this.platformVersion = mPlatformVersionNum
    }
}

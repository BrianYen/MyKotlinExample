package com.example.bryanyen.kotlintest.util.log

import android.util.Log

/**
 * Created by bryan.yen on 2017/4/17.
 */

object YfyShopLog {

    private val TAG = "YfyShop"
    private val DEBUG = true

    fun d(title: String, message: String) {
        if (DEBUG) {
            Log.d(TAG, "[$title], $message")
        }
    }

    fun e(title: String, message: String) {
        if (DEBUG) {
            Log.e(TAG, "[$title], $message")
        }
    }
}

package com.example.bryanyen.kotlintest.intent

import android.app.Activity
import android.widget.Toast
import com.example.bryanyen.kotlintest.config.Constant

/*
 * Created by bryan.yen on 2017/4/19.
 *
 * Convert Code To Kotlin on 2017/05/23.
 *
 */

object ErrorListener {
    fun response(activity: Activity, errorCode: Int, errorMessage: String) {
        activity.runOnUiThread {
            when (errorCode) {
                Constant.ERROR_NO_INTERNAL -> Toast.makeText(activity.applicationContext, "", Toast.LENGTH_SHORT).show()
                Constant.ERROR_LOGIN_INTERNAL -> Toast.makeText(activity.applicationContext, "", Toast.LENGTH_SHORT).show()
                Constant.ERROR_LOGIN_ACCOUNT -> Toast.makeText(activity.applicationContext, "", Toast.LENGTH_SHORT).show()
                Constant.ERROR_CONNECTION_TIME_OUT -> Toast.makeText(activity.applicationContext, "", Toast.LENGTH_SHORT).show()
                Constant.ERROR_SOCKET_TIME_OUT -> Toast.makeText(activity.applicationContext, "", Toast.LENGTH_SHORT).show()
                Constant.ERROR_JSON -> checkJsonErrorCode(activity, errorMessage)
                else -> Toast.makeText(activity.applicationContext, "", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkJsonErrorCode(activity: Activity, errorMessage: String) {
        val errorCode = Integer.parseInt(errorMessage)
        when (errorCode) {
            Constant.ERROR_SERVER_MISS_PARAMES -> Toast.makeText(activity.applicationContext, "參數不足", Toast.LENGTH_SHORT).show()
            Constant.ERROR_SERVER_NO_SERCH_PLACE -> Toast.makeText(activity.applicationContext, "公設不存在", Toast.LENGTH_SHORT).show()
            Constant.ERROR_SERVER_POINT_NOT_ENOUGH -> Toast.makeText(activity.applicationContext, "", Toast.LENGTH_SHORT).show()
            Constant.ERROR_SERVER_PERIOD_FAILURE -> Toast.makeText(activity.applicationContext, "公設預約失敗", Toast.LENGTH_SHORT).show()
            Constant.ERROR_SERVER_CANCEL_RENT_FAILURE -> Toast.makeText(activity.applicationContext, "公設取消失敗", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(activity.applicationContext, errorCode.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}

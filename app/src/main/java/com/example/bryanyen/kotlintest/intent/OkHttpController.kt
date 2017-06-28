package com.example.bryanyen.kotlintest.intent

import com.example.bryanyen.kotlintest.config.Constant
import com.example.bryanyen.kotlintest.util.Utils
import com.example.bryanyen.kotlintest.util.log.YfyShopLog
import okhttp3.*
import java.io.IOException
import java.util.*

/**
 * Created by bryan.yen on 2017/5/12.
 *
 *
 * 使用 OkHttp 打api
 */

class OkHttpController {
    private val JSON = MediaType.parse("application/json; charset=utf-8")

    fun getPublicUtilityListFromServer(callBack: OkHttpResponseListener.GetPublicUtilityListCallBack) {
        val urlPrefix = ""
        val requestParam = HashMap<String, String>()
        requestParam.put("community", "10084")

        val request = Request.Builder()
                .url(Utils.buildURL(urlPrefix, requestParam))
                .build()
        val okHttpClient = OkHttpClient()
        val call = okHttpClient.newCall(request)

        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                YfyShopLog.e("okHttp", "onFailure :" + e.message)
                callBack.onError(Constant.ERROR_NO_INTERNAL, "")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    callBack.onSuccess(response.body().string())
                } else {
                    callBack.onError(response.code(), response.message())
                }
            }
        })
    }
}

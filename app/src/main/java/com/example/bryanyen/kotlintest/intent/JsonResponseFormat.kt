package com.example.bryanyen.kotlintest.intent

import com.example.bryanyen.kotlintest.model.PrivilegeStoreTypeItem
import com.example.bryanyen.kotlintest.model.PublicUtilityBookingStateItem
import com.example.bryanyen.kotlintest.model.PublicUtilityManagementItem
import com.example.bryanyen.kotlintest.model.PublicUtilityUserPointItem
import com.example.bryanyen.kotlintest.util.log.YfyShopLog
import org.json.JSONException
import org.json.JSONObject
import java.util.*

/**
 * Created by bryan.yen on 2017/4/24.
 */

object JsonResponseFormat {
    fun getPrivilegeStoreType(requestData: String): ArrayList<PrivilegeStoreTypeItem>? {
        val privilegeStoreTypeItemArrayList = ArrayList<PrivilegeStoreTypeItem>()

        try {
            if (requestData == "") {
                return privilegeStoreTypeItemArrayList
            }
            val jsonObject = JSONObject(requestData)
            if (jsonObject.has("privilege_type")) {
                val jsonArray = jsonObject.getJSONArray("privilege_type")

                for (i in 0..jsonArray.length() - 1) {
                    val jsObject = jsonArray.getJSONObject(i)

                    val privilegeStoreTypeItem = PrivilegeStoreTypeItem()
                    privilegeStoreTypeItem.seq = jsObject.getString("seq")
                    privilegeStoreTypeItem.name = jsObject.getString("name")

                    privilegeStoreTypeItemArrayList.add(privilegeStoreTypeItem)
                }
            }

            return privilegeStoreTypeItemArrayList
        } catch (e: JSONException) {
            e.printStackTrace()
            YfyShopLog.e("getPrivilegeStoreType", e.message as String)
        }

        return null
    }

    fun getPublicUtilityListFromJson(requestData: String, callBack: JsonResponseFormatListener.GetPublicUtilityListFromJsonCallBack) {
        val publicUtilityManagementItemArrayList = ArrayList<PublicUtilityManagementItem>()
        try {
            if (requestData == "") {
                callBack.onJsonSuccess(publicUtilityManagementItemArrayList)
                return
            }
            val jsonObject = JSONObject(requestData)
            if (jsonObject.has("errorcode")) {
                val errorCode = jsonObject.getString("errorcode")
                if (errorCode != "0") {
                    callBack.onJsonError(errorCode)
                    return
                }
            }
            if (jsonObject.has("data")) {
                val jsonArray = jsonObject.getJSONArray("data")

                for (i in 0..jsonArray.length() - 1) {
                    val jsObject = jsonArray.getJSONObject(i)

                    val publicUtilityManagementItem = PublicUtilityManagementItem()
                    publicUtilityManagementItem.id = jsObject.getString("id")
                    publicUtilityManagementItem.name = jsObject.getString("name")
                    publicUtilityManagementItem.description = jsObject.getString("description")
                    publicUtilityManagementItem.img = jsObject.getString("img")
                    publicUtilityManagementItem.length = jsObject.getString("length")
                    publicUtilityManagementItem.unitMinutes = jsObject.getString("unit_minutes")
                    publicUtilityManagementItem.points = jsObject.getString("point")
                    publicUtilityManagementItem.startAtWeekday = jsObject.getString("start_at_weekday")
                    publicUtilityManagementItem.endAtWeekday = jsObject.getString("end_at_weekday")
                    publicUtilityManagementItem.startAtWeekend = jsObject.getString("start_at_weekend")
                    publicUtilityManagementItem.endAtWeekend = jsObject.getString("end_at_weekend")

                    publicUtilityManagementItemArrayList.add(publicUtilityManagementItem)
                }
            }

            callBack.onJsonSuccess(publicUtilityManagementItemArrayList)
        } catch (e: JSONException) {
            e.printStackTrace()
            YfyShopLog.e("getPublicUtilityListFromJson", e.message as String)
        }

    }

    fun getBookingListFromJson(requestData: String, callBack: JsonResponseFormatListener.GetBookingListFromJsonCallBack) {
        val publicUtilityBookingItemArrayList = ArrayList<PublicUtilityBookingStateItem>()
        try {
            if (requestData == "") {
                callBack.onJsonSuccess(publicUtilityBookingItemArrayList)
                return
            }
            val jsonObject = JSONObject(requestData)
            if (jsonObject.has("errorcode")) {
                val errorCode = jsonObject.getString("errorcode")
                if (errorCode != "0") {
                    callBack.onJsonError(errorCode)
                    return
                }
            }
            if (jsonObject.has("data")) {
                val jsonArray = jsonObject.getJSONArray("data")

                for (i in 0..jsonArray.length() - 1) {
                    val jsObject = jsonArray.getJSONObject(i)

                    val publicUtilityBookingItem = PublicUtilityBookingStateItem()
                    publicUtilityBookingItem.id = jsObject.getString("id")
                    if (jsObject.has("user_id")) {
                        publicUtilityBookingItem.userId = jsObject.getString("user_id")
                    }
                    if (jsObject.has("place_id")) {
                        publicUtilityBookingItem.placeId = jsObject.getString("place_id")
                    }
                    publicUtilityBookingItem.startAt = jsObject.getString("start_at")
                    publicUtilityBookingItem.endAt = jsObject.getString("end_at")

                    publicUtilityBookingItemArrayList.add(publicUtilityBookingItem)
                }
            }

            callBack.onJsonSuccess(publicUtilityBookingItemArrayList)
        } catch (e: JSONException) {
            e.printStackTrace()
            YfyShopLog.e("getBookingListByPlaceFromJson", e.message as String)
        }

    }


    fun getUserPointFromJson(requestData: String, callBack: JsonResponseFormatListener.GetUserPointFromJsonCallBack) {
        val publicUtilityUserPointItem = PublicUtilityUserPointItem()

        try {
            if (requestData == "") {
                callBack.onJsonSuccess(publicUtilityUserPointItem)
                return
            }
            val jsonObject = JSONObject(requestData)
            if (jsonObject.has("errorcode")) {
                val errorCode = jsonObject.getString("errorcode")
                if (errorCode != "0") {
                    callBack.onJsonError(errorCode)
                    return
                }
            }
            if (jsonObject.has("basic_points")) {
                publicUtilityUserPointItem.basicPoints = jsonObject.getString("basic_points")
            }
            if (jsonObject.has("security_points")) {
                publicUtilityUserPointItem.securityPoints = jsonObject.getString("security_points")
            }

            callBack.onJsonSuccess(publicUtilityUserPointItem)
        } catch (e: JSONException) {
            e.printStackTrace()
            YfyShopLog.e("getPublicUtilityListFromJson", e.message as String)
        }

    }

    fun goBookingPlaceFromJson(requestData: String, callBack: JsonResponseFormatListener.GoBookingPlaceFromJsonCallBack) {
        try {
            val jsonObject = JSONObject(requestData)

            if (jsonObject.has("errorcode")) {
                val errorCode = jsonObject.getString("errorcode")
                if (errorCode != "0") {
                    callBack.onJsonError(errorCode)
                    return
                }
            }
            if (jsonObject.has("rent_id")) {
                val rentId = jsonObject.getString("rent_id")
                callBack.onJsonSuccess(rentId)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            YfyShopLog.e("goBookingPlaceFromJson", e.message as String)
        }

    }
}

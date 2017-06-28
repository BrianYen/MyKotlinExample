package com.example.bryanyen.kotlintest.intent

import com.example.bryanyen.kotlintest.model.PublicUtilityBookingStateItem
import com.example.bryanyen.kotlintest.model.PublicUtilityManagementItem
import com.example.bryanyen.kotlintest.model.PublicUtilityUserPointItem
import java.util.*

/**
 * Created by bryan.yen on 2017/5/10.
 */

class JsonResponseFormatListener {

    interface GetRequestErrorCallback {
        fun onJsonError(errorMessage: String)
    }

    interface GetPublicUtilityListFromJsonCallBack : GetRequestErrorCallback {
        fun onJsonSuccess(list: ArrayList<PublicUtilityManagementItem>)
    }

    interface GetBookingListFromJsonCallBack : GetRequestErrorCallback {
        fun onJsonSuccess(list: ArrayList<PublicUtilityBookingStateItem>)
    }

    interface GetUserPointFromJsonCallBack : GetRequestErrorCallback {
        fun onJsonSuccess(publicUtilityUserPointItem: PublicUtilityUserPointItem)
    }

    interface GoBookingPlaceFromJsonCallBack : GetRequestErrorCallback {
        fun onJsonSuccess(rentId: String)
    }
}

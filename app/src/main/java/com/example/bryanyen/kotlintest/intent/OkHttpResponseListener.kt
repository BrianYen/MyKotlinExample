package com.example.bryanyen.kotlintest.intent

/**
 * Created by bryan.yen on 2017/4/21.
 */

class OkHttpResponseListener {
    interface OkHttpErrorCallBack {
        fun onError(errorCode: Int, errorMessage: String)
    }

    interface LoginToServerCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetLastNewsDataCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetVisitorRecordDataCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetPackageDataCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetUnReadCountCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface DeleteTokenCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetPrivilegeStoreCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetPrivilegeStoreTypeCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetPublicUtilityListCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetBookingListCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GetUserPointCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }

    interface GoBookingPlaceCallBack : OkHttpErrorCallBack {
        fun onSuccess(requestData: String)
    }
}

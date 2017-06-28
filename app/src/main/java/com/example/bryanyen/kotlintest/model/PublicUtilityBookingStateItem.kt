package com.example.bryanyen.kotlintest.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by bryan.yen on 2017/5/9.
 */

class PublicUtilityBookingStateItem : Parcelable {

    var id: String? = null
    var userId: String? = null
    var placeId: String? = null
    var startAt: String? = null
    var endAt: String? = null

    constructor() {

    }

    protected constructor(`in`: Parcel) {
        id = `in`.readString()
        userId = `in`.readString()
        placeId = `in`.readString()
        startAt = `in`.readString()
        endAt = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(userId)
        dest.writeString(placeId)
        dest.writeString(startAt)
        dest.writeString(endAt)
    }

    companion object {

        val CREATOR: Parcelable.Creator<PublicUtilityBookingStateItem> = object : Parcelable.Creator<PublicUtilityBookingStateItem> {
            override fun createFromParcel(`in`: Parcel): PublicUtilityBookingStateItem {
                return PublicUtilityBookingStateItem(`in`)
            }

            override fun newArray(size: Int): Array<PublicUtilityBookingStateItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}

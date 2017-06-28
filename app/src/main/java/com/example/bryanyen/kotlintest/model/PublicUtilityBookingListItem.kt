package com.example.bryanyen.kotlintest.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by bryan.yen on 2017/5/9.
 */

class PublicUtilityBookingListItem : Parcelable {

    var rentId: String? = null
    var placeId: String? = null
    var point: String? = null
    var startTime: String? = null
    var endTime: String? = null
    var count = 1


    constructor() {

    }

    protected constructor(`in`: Parcel) {
        rentId = `in`.readString()
        placeId = `in`.readString()
        point = `in`.readString()
        startTime = `in`.readString()
        endTime = `in`.readString()
        count = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(rentId)
        dest.writeString(placeId)
        dest.writeString(point)
        dest.writeString(startTime)
        dest.writeString(endTime)
        dest.writeInt(count)
    }

    companion object {

        val CREATOR: Parcelable.Creator<PublicUtilityBookingListItem> = object : Parcelable.Creator<PublicUtilityBookingListItem> {
            override fun createFromParcel(`in`: Parcel): PublicUtilityBookingListItem {
                return PublicUtilityBookingListItem(`in`)
            }

            override fun newArray(size: Int): Array<PublicUtilityBookingListItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}

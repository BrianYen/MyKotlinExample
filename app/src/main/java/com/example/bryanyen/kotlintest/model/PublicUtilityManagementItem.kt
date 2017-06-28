package com.example.bryanyen.kotlintest.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by bryan.yen on 2017/5/8.
 */

class PublicUtilityManagementItem : Parcelable {
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var img: String? = null
    var length: String? = null
    var unitMinutes: String? = null
    var points: String? = null
    var startAtWeekday: String? = null
    var endAtWeekday: String? = null
    var startAtWeekend: String? = null
    var endAtWeekend: String? = null

    constructor() {

    }

    constructor(parcel: Parcel) {
        id = parcel.readString()
        name = parcel.readString()
        description = parcel.readString()
        img = parcel.readString()
        length = parcel.readString()
        unitMinutes = parcel.readString()
        points = parcel.readString()
        startAtWeekday = parcel.readString()
        endAtWeekday = parcel.readString()
        startAtWeekend = parcel.readString()
        endAtWeekend = parcel.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeString(description)
        dest.writeString(img)
        dest.writeString(length)
        dest.writeString(unitMinutes)
        dest.writeString(points)
        dest.writeString(startAtWeekday)
        dest.writeString(endAtWeekday)
        dest.writeString(startAtWeekend)
        dest.writeString(endAtWeekend)
    }

    companion object {

        val CREATOR: Parcelable.Creator<PublicUtilityManagementItem> = object : Parcelable.Creator<PublicUtilityManagementItem> {
            override fun createFromParcel(`in`: Parcel): PublicUtilityManagementItem {
                return PublicUtilityManagementItem(`in`)
            }

            override fun newArray(size: Int): Array<PublicUtilityManagementItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}

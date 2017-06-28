package com.example.bryanyen.kotlintest.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by bryan.yen on 2017/5/3.
 */

class UnReadInfoItem : Parcelable {

    var noticeCount = 0
    var packageCount = 0
    var vistorCount = 0

    constructor() {

    }

    constructor(parcel: Parcel) {
        noticeCount = parcel.readInt()
        packageCount = parcel.readInt()
        vistorCount = parcel.readInt()
    }

    val totalCount: Int
        get() = this.noticeCount + this.packageCount + this.vistorCount

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(noticeCount)
        dest.writeInt(packageCount)
        dest.writeInt(vistorCount)
    }

    companion object {

        val CREATOR: Parcelable.Creator<UnReadInfoItem> = object : Parcelable.Creator<UnReadInfoItem> {
            override fun createFromParcel(`in`: Parcel): UnReadInfoItem {
                return UnReadInfoItem(`in`)
            }

            override fun newArray(size: Int): Array<UnReadInfoItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}

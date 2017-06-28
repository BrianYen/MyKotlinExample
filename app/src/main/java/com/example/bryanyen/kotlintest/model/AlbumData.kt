package com.example.bryanyen.kotlintest.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class AlbumData {
    var albumTitle: String? = null
    var albumImgUrl: String? = null
    var updateDate: String? = null
    var photoList: ArrayList<PhotoData>? = null
    var albumThumbStartX: String? = null
    var albumThumbStartY: String? = null
    var albumThumbWidth: String? = null
    var isLoading = false

    val photoCount: Int
        get() {
            if (photoList == null) {
                return 0
            }
            return photoList!!.size
        }

    class PhotoData : Parcelable {
        var photoId: String? = null
        var photoTitle: String? = null
        var photoImgUrl: String? = null
        var likeCount: String? = null
        var liked: String? = null
        var createDate: String? = null
        /* For cropping some portion of bitmap, and the range is square. */
        var thumbStartX: String? = null
        var thumbStartY: String? = null
        var thumbWidth: String? = null
        var isLoading = false
        // 160129 By Rab add (S) - Thumb Image Url.
        // 160129 By Rab add (E) - Thumb Image Url.

        var thumbImgUrl: String? = null   // 160129 By Rab add Thumb Image Url.

        constructor(`in`: Parcel) {
            readFromParcel(`in`)
        }

        constructor() {}

        override fun describeContents(): Int {
            return 0
        }

        private fun readFromParcel(`in`: Parcel) {
            photoId = `in`.readString()
            photoTitle = `in`.readString()
            photoImgUrl = `in`.readString()
            likeCount = `in`.readString()
            liked = `in`.readString()
            createDate = `in`.readString()
            thumbStartX = `in`.readString()
            thumbStartY = `in`.readString()
            thumbWidth = `in`.readString()
            thumbImgUrl = `in`.readString()   // 160129 By Rab add Thumb Image Url.
            isLoading = false
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(photoId)
            dest.writeString(photoTitle)
            dest.writeString(photoImgUrl)
            dest.writeString(likeCount)
            dest.writeString(liked)
            dest.writeString(createDate)
            dest.writeString(thumbStartX)
            dest.writeString(thumbStartY)
            dest.writeString(thumbWidth)
            dest.writeString(thumbImgUrl)   // 160129 By Rab add Thumb Image Url.
        }

        companion object {
            val CREATOR: Parcelable.Creator<PhotoData> = object : Parcelable.Creator<PhotoData> {
                override fun createFromParcel(`in`: Parcel): PhotoData {
                    return PhotoData(`in`)
                }

                override fun newArray(size: Int): Array<PhotoData?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }
}

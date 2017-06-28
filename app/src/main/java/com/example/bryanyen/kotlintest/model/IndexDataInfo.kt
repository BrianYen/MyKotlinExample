package com.example.bryanyen.kotlintest.model

import org.json.JSONArray

import java.io.InputStream

class IndexDataInfo {
    var id: String? = null
    var store: String? = null
    var storeName: String? = null
    var storeName1: String? = null
    var storeTel: String? = null
    var storeTelExt: String? = null
        private set
    var zip: String? = null
    var address: String? = null
    var latitude: String? = null
    var longitude: String? = null
    var category: String? = null
    var categorySeq: String? = null
    var projectIntro: String? = null
    var imageUrl: String? = null
    var serviceTime: String? = null
    var holiday: String? = null
    var info: String? = null
    var nameTitle: String? = null
    var phoneTitle: String? = null
    var addressTitle: String? = null
    var serviceTimeTitle: String? = null
    var holidayTitle: String? = null
    var infoTitle: String? = null
    var infoFrom: String? = null
    var storeLinkTitle: String? = null
    var storeLink: String? = null
    var avgCostTitle: String? = null
    var avgCost: String? = null
    var customJsonArray: JSONArray? = null
    var distance: Int = 0
    var couponCount: Int = 0
    var mobile = false
    var app = false
    var isLoading = false
    var imageIS: InputStream? = null

    fun setStoreTelWithExt(tel: String) {
        this.storeTelExt = tel
    }

    companion object {
        private val TAG = "IndexDataInfo"
    }
}

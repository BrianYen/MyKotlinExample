package com.example.bryanyen.kotlintest.model

class PublicItem {

    var listTagId: Int = 0
    var titleId: Int = 0
        private set
    var intentClass: Class<*>? = null
    private val bundleTitle: String? = null

    fun setTitle(titleId: Int) {
        this.titleId = titleId
    }
}

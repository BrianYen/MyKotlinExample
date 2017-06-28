package com.example.bryanyen.kotlintest.config

/**
 * Created by bryan.yen on 2017/4/19.
 */

object Constant {
    /* For connection and socket time out tag */
    val ERR_HTTP_TIME_OUT = "time_out"
    //Perform http tag
    val CHECKUNREAD = "checkunread"
    val DEVICETYPE = "android"
    //Function Count
    val ANNOUNCE = "Announce"
    val NOTICE = "Notice"
    val INFORMATION = "Information"
    val CONTACT = "Contact"
    val EVENT = "Event"
    //  public static final String PROFILE = "Profile";
    val PHOTO = "Photo"
    val PRIVILEGE = "Privilege"
    val PRIVILEGE_NOMAL = "Privilege_normal"
    val PRIVILEGE_INDEX = "Privilege_index"
    val POST_NOMAL = "Post_normal"
    val POST_CROSS = "Post_cross"
    val ORDER = "Order"
    val POST = "Post"
    val FEEDBACK = "Feedback"
    val PUBLIC = "Public"
    val SETUP = "Setting"
    val PAYMENT = "Payment"
    val SURVEY = "Survey"  // 160314 By Rab add.
    val NOTICE_CATALOG = "Notice_catalog"
    val COMMUNITY_CATALOG = "Community_catalog"
    //Setup related
    val SIGNATURE = "signature"
    val LOGINSTATE = "loginstate"
    val ACCOUNT = "account"
    val USERID = "user_id"
    val OBJECTID = "object_id"
    val SOUNDSETTING = "issound"
    val UNREADSETTING = "isunread"
    val PUSHSETTING = "ispush"
    val ISSTORE = "isstore"
    val SETTING = "setting"
    val OPENDATA = "opendata_v1"
    val HOUSEHOLD_NUMBER = "hosehold_number"
    val COMMUNITY = "community"
    val COMMUNITY_NAME = "community_name"
    val LATITUDE = "latitude"
    val LONGITUDE = "longitude"
    val CITY = "city"
    val EBUSFAVORITE = "EBusFavoriteCount"
    val FEEDBACKCOUNT = "feedbackCount"
    val DEVICEID = "device_id"
    val DELETEALLFLAG = "isdeleteall"
    val ISREGISTED = "isreg"
    val CHECKFROMSETTING = "fromsetting"
    val ISSUPPORTPUSH = "issupportpush"
    val SHOWINTRO = "showintro"
    val BANNER = "UpperBottom"
    val CENTER = "Center"
    val COMMONVERSION = "common_version"
    val COMMONPREJSON = "common_pre_json"
    val TOKENREFRASH = "tokenrefrash"
    /*
    * Photo album list type
    *  0: List View, default type
    *  1: Grid View
    */
    val PHOTO_ALBUM_TYPE = "photo_album_type"
    val REQ_REPORT_CLCK_COUNT = "req_report_click_count"

    val GSF_PACKAGE = "com.google.android.gsf"
    val REQUEST_REGISTRATION_INTENT = "com.google.android.c2dm.intent" + ".REGISTER"

    // Error Code
    val ERROR_SERVER_MISS_PARAMES = 601
    val ERROR_SERVER_NO_SERCH_PLACE = 602
    val ERROR_SERVER_POINT_NOT_ENOUGH = 603
    val ERROR_SERVER_PERIOD_FAILURE = 604
    val ERROR_SERVER_CANCEL_RENT_FAILURE = 605

    val ERROR_NO_INTERNAL = 800
    val ERROR_CONNECTION_TIME_OUT = 801
    val ERROR_SOCKET_TIME_OUT = 802
    val ERROR_JSON = 803

    val ERROR_LOGIN_INTERNAL = 850
    val ERROR_LOGIN_ACCOUNT = 851

    // Activity ACTION
    val ACTION_UNREAD_NOTICE_UPDATE = 0x10
    val ACTION_UNREAD_PACKAGE_UPDATE = 0x11
    val ACTION_UNREAD_VISTOR_UPDATE = 0x12
    val ACTION_PRIVILEGE_STORE_SEARCH = 0x13
    val ACTION_UNREAD_MAIN_UPDATE = 0x14

    // Http Request Cache
    val CACHE_PRIVILEGE_STORE = "JsonGetPrivilegeStore"
    val CACHE_PRIVILEGE_STORE_TYPE = "JsonGetPrivilegeStoreType"

    // Date Format
    val DATE_FORMAT_ALL = "yyyy-MM-dd HH:mm:ss"
    val DATE_FORMAT_YEAR = "yyyy-MM-dd"
    val DATE_FORMAT_TIME = "HH:mm:ss"
    val DATE_FORMAT_TIME_NO_SEC = "HH:mm"

    // Bundle Type
    val BUNDLE_PUBLIC_UTILITY_LIST = "publicUtilityList"

}

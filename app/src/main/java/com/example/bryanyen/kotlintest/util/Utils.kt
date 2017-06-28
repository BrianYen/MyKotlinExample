package com.example.bryanyen.kotlintest.util


import android.net.Uri
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ListView
import com.example.bryanyen.kotlintest.config.Constant
import com.example.bryanyen.kotlintest.model.PublicUtilityManagementItem
import java.net.MalformedURLException
import java.net.URI
import java.net.URISyntaxException
import java.net.URL
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by bryan.yen on 2017/4/18.
 */

object Utils {
    private var lastClickTime: Long = 0

//    internal fun convertToHex(data: ByteArray): String {
//        val buf = StringBuilder()
//        for (b in data) {
//            var halfbyte = b.ushr(4) and 0x0F
//            var two_halfs = 0
//            do {
//                buf.append(if (0 <= halfbyte && halfbyte <= 9)
//                    ('0' + halfbyte).toChar()
//                else
//                    ('a' + (halfbyte - 10)).toChar())
//                halfbyte = b and 0x0F
//            } while (two_halfs++ < 1)
//        }
//        return buf.toString()
//    }

    ////    public static boolean setButtonFeedBackGrayToNull(View view, MotionEvent event) {
    ////        ImageButton button = (ImageButton) view;
    ////        if (event.getAction() == MotionEvent.ACTION_DOWN) {
    ////            if (LBUtility.getColorValue() < 200) {
    ////                button.setColorFilter(Color.GRAY);
    ////            } else {
    ////                button.setColorFilter(Color.rgb(225, 225, 225));
    ////            }
    ////            return false;
    ////        } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent
    /// .ACTION_CANCEL) {
    ////            if (LBUtility.getColorValue() < 200) {
    ////                button.setColorFilter(null);
    ////            } else {
    ////                button.setColorFilter(Color.rgb(85, 85, 85));
    ////            }
    ////            return false;
    ////        }
    ////        return false;
    ////    }
    ////
    ////    public static boolean setButtonFeedBackGrayToWhite(View view, MotionEvent event) {
    ////        ImageButton button = (ImageButton) view;
    ////        if (event.getAction() == MotionEvent.ACTION_DOWN) {
    ////            button.setColorFilter(Color.GRAY);
    ////            return false;
    ////        } else if (event.getAction() == MotionEvent.ACTION_UP) {
    ////            if (LBUtility.getColorValue() < 200) {
    ////                button.setColorFilter(Color.WHITE);
    ////            } else {
    ////                button.setColorFilter(Color.rgb(85, 85, 85));
    ////            }
    ////            return false;
    ////        }
    ////        return false;
    ////    }
    //
    //    public static boolean setButtonFeedBackWhiteToLightGray(View view, MotionEvent event) {
    //        ImageButton button = (ImageButton) view;
    //        if (event.getAction() == MotionEvent.ACTION_DOWN) {
    //            button.setColorFilter(Color.GRAY);
    //            return false;
    //        } else if (event.getAction() == MotionEvent.ACTION_UP) {
    //            if (LBUtility.getColorValue() < 200) {
    //                button.setColorFilter(Color.rgb(211, 211, 211));
    //            } else {
    //                button.setColorFilter(Color.WHITE);
    //            }
    //            return false;
    //        }
    //        return false;
    //    }

    /**
     * 重新計算ListView的高度，使其可以在ScrollView下正常運作

     * @param listView list view
     */
    fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter = listView.adapter ?: // pre-condition
                return

        var totalHeight = listView.paddingTop + listView.paddingBottom
        for (i in 0..listAdapter.count - 1) {
            val listItem = listAdapter.getView(i, null, listView)
            if (listItem is ViewGroup) {
                listItem.setLayoutParams(AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        AbsListView.LayoutParams.WRAP_CONTENT))
            }
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }

        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        listView.layoutParams = params
    }

    val todayDate: Date
        get() {
            val calendar = Calendar.getInstance()
            return calendar.time
        }

    val todayString: String
        get() {
            val sdf = SimpleDateFormat(Constant.DATE_FORMAT_YEAR, Locale.TAIWAN)
            val cal = Calendar.getInstance()
            return sdf.format(cal.time)
        }

    fun isDateAfter(currentYear: Int, currentMonth: Int, currentDay: Int): Boolean {
        val mCalendar = Calendar.getInstance()
        val year = mCalendar.get(Calendar.YEAR)
        val month = mCalendar.get(Calendar.MONTH)
        val day = mCalendar.get(Calendar.DAY_OF_MONTH)

        if (currentYear >= year) {
            if (currentMonth >= month) {
                if (currentDay >= day) {
                    return true
                }
            }
        }

        return false
    }

    fun convertStringToDate(dateString: String, dateFormat: String = Constant.DATE_FORMAT_YEAR): Date? {
        val sdf = SimpleDateFormat(dateFormat, Locale.TAIWAN)
        var dateParse: Date? = null
        try {
            dateParse = sdf.parse(dateString)
        } catch (e: java.text.ParseException) {
            e.printStackTrace()
        }

        return dateParse
    }

    fun convertTimeStringToDate(timeString: String): Date? {
        val sdf = SimpleDateFormat(Constant.DATE_FORMAT_TIME, Locale.TAIWAN)
        var dateParse: Date? = null
        try {
            dateParse = sdf.parse(timeString)
        } catch (e: java.text.ParseException) {
            e.printStackTrace()
        }

        return dateParse
    }

    fun convertDateString(dateString: String, dateFormat: String): String {
        val sdf = SimpleDateFormat(Constant.DATE_FORMAT_ALL, Locale.TAIWAN)
        var d: Date? = null
        try {
            d = sdf.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val cal = Calendar.getInstance()
        cal.time = d

        val simpleDateFormatNoSecond = SimpleDateFormat(dateFormat, Locale.TAIWAN)
        return simpleDateFormatNoSecond.format(cal.time)
    }

    fun convertDateStringToTime(dateString: String): String {
        return convertDateString(dateString, Constant.DATE_FORMAT_TIME)
    }

    fun convertTimeStringToNoSecond(dateString: String): String {
        val sdf = SimpleDateFormat(Constant.DATE_FORMAT_TIME, Locale.TAIWAN)
        var d: Date? = null
        try {
            d = sdf.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val cal = Calendar.getInstance()
        cal.time = d

        val simpleDateFormatNoSecond = SimpleDateFormat(Constant.DATE_FORMAT_TIME_NO_SEC, Locale
                .TAIWAN)
        return simpleDateFormatNoSecond.format(cal.time)
    }

    fun addTimeFromTimeString(dateString: String, time: String): String {
        val sdf = SimpleDateFormat(Constant.DATE_FORMAT_TIME, Locale.TAIWAN)
        var d: Date? = null
        try {
            d = sdf.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val cal = Calendar.getInstance()
        cal.time = d
        cal.add(Calendar.MINUTE, Integer.parseInt(time))

        return sdf.format(cal.time)
    }

    fun publicUtilityDateFormat(publicUtilityManagementItem: PublicUtilityManagementItem): String {
        val dayStart = convertTimeStringToNoSecond(publicUtilityManagementItem.startAtWeekday as String)
        val dayEnd = convertTimeStringToNoSecond(publicUtilityManagementItem.startAtWeekend as String)
        val weekdayStart = convertTimeStringToNoSecond(publicUtilityManagementItem.endAtWeekday as String)
        val weekdayEnd = convertTimeStringToNoSecond(publicUtilityManagementItem.endAtWeekend as String)

        val weekdayFormat = "週一至週五 $dayStart 至 $dayEnd"
        val weekendFormat = "週六及週日 $weekdayStart 至 $weekdayEnd"

        return weekdayFormat + " , " + weekendFormat
    }

    val isWeekendDate: Boolean
        get() {
            val cal = Calendar.getInstance()
            return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
        }

    fun buildURI(url: String, params: Map<String, String>): URI? {

        // build url with parameters.
        val builder = Uri.parse(url).buildUpon()
        for ((key, value) in params) {
            builder.appendQueryParameter(key, value)
        }

        try {
            return URI(builder.build().toString())
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }

        return null
    }

    fun buildURL(url: String, params: Map<String, String>): URL? {

        // build url with parameters.
        val builder = Uri.parse(url).buildUpon()
        for ((key, value) in params) {
            builder.appendQueryParameter(key, value)
        }
        try {
            return URL(builder.build().toString())
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        return null
    }

    val isFastDoubleClick: Boolean
        get() {
            val time = System.currentTimeMillis()
            val timeD = time - lastClickTime
            if (timeD in 1..999) {
                return true
            }
            lastClickTime = time
            return false
        }
}

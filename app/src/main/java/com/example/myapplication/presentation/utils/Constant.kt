package com.example.myapplication.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

object Constant {

    const val APIkEY = "Xas5U8gWBrFtV3UxAWRyRhNlRJAUsEKa3XjaF6Rf"

    fun getStartDate(): String {
        return SimpleDateFormat("yyyy-MM-dd").format(Date())
    }

    fun getEndDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, +7)
        val nextWeek = calendar.time
        return SimpleDateFormat("yyyy-MM-dd").format(nextWeek)
    }



//    fun getCurrentWeekDayStartTime(): Date {
//        val shortSdf =  SimpleDateFormat("yyyy-MM-dd")
//        val longSdf = SimpleDateFormat(
//            "yyyy-MM-dd HH:mm:ss")
//        val c = Calendar.getInstance()
//        try {/*from  w w  w.  ja v a 2s .com*/
//           val weekday:Int = c.get(Calendar.DAY_OF_WEEK) - 2
//            c.add(Calendar.DATE, -weekday);
//            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"))
//        } catch (e:Exception) {
//            e.printStackTrace()
//        }
//        return c.getTime()
//    }

}
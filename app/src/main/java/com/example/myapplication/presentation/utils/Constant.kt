package com.example.myapplication.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

object Constant {

        const val APIkEY="Xas5U8gWBrFtV3UxAWRyRhNlRJAUsEKa3XjaF6Rf"

        fun getStartDate(): String {
            return SimpleDateFormat("yyyy-MM-dd").format(Date())
        }

        fun getEndDate(): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, +7)
            val nextWeek = calendar.time
            return SimpleDateFormat("yyyy-MM-dd").format(nextWeek)
        }

}
package com.ksmandroid.workshopjetpackcompose.util

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object DateFormatUtil {
    fun formatDate(rawDate: String): String {

        try {
            val inputPattern = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val outputPattern = SimpleDateFormat("dd MMM yyyy HH:mm")

            val date = inputPattern.parse(rawDate)
            val output = outputPattern.format(date)

            return output
        }
        catch (e: Exception){
            return rawDate
        }

    }
}
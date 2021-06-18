package com.rsschool.quiz.utility

import android.content.Context
import android.content.SharedPreferences

object AppPreference {

    private const val NAME_PREFERENCE = "preferences"

    private lateinit var preferences: SharedPreferences

    fun getPreference(context: Context): SharedPreferences {
        preferences = context.getSharedPreferences(NAME_PREFERENCE, Context.MODE_PRIVATE)
        return preferences
    }

    fun saveChoiceQuestionPref(key: String, value: Int) {
        preferences.edit()
            .putInt(key, value)
            .apply()
    }

    fun loadChoiceQuestionPref(key: String): Int {
        return preferences.getInt(key, 0)
    }

    fun clearSharedPref() {
        preferences.edit().clear().apply()
    }

}
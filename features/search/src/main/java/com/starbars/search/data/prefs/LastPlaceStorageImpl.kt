package com.starbars.search.data.prefs

import android.content.SharedPreferences
import androidx.core.content.edit

internal class LastPlaceStorageImpl(
    private val sharedPreferences: SharedPreferences
) : LastPlaceStorage {
    override fun get(): String? {
        return sharedPreferences.getString(KEY_LAST_INPUT, null)
    }

    override fun save(place: String) {
        sharedPreferences.edit {
            putString(KEY_LAST_INPUT, place)
        }
    }

    companion object {
        private const val KEY_LAST_INPUT = "last_input"
    }
}
package ro.btanase.chucknorris.models

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class AppSharedPreferences(context : Context) {
    private val preferences : SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_FILENAME, Context.MODE_PRIVATE)

    var lastSyncDate: Date?
        get() {
            val date = preferences.getLong(KEY_LAST_SYNC_DATE, LAST_SYNC_DATE_DEFAULT)
            return if (date == LAST_SYNC_DATE_DEFAULT) null
            else Date(date)
        }
        set(value) {
            val date = value?.time ?: LAST_SYNC_DATE_DEFAULT
            preferences.edit().putLong(KEY_LAST_SYNC_DATE, date).apply()
        }

    var lastCategory: String
        get() {
            return preferences.getString(KEY_LAST_CATEGORY, LAST_CATEGORY_DEFAULT) ?: LAST_CATEGORY_DEFAULT
        }
        set (value) {
            preferences.edit().putString(KEY_LAST_CATEGORY, value).apply()
        }

    companion object {
        const val SHARED_PREFERENCES_FILENAME = "chucknorris-prefs"
        const val KEY_LAST_SYNC_DATE = "last-sync-date"
        const val LAST_SYNC_DATE_DEFAULT = -1L
        const val KEY_LAST_CATEGORY = "last-category"
        const val LAST_CATEGORY_DEFAULT = "ALL"
    }
}
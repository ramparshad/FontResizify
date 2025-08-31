package com.ramparshad.font_resizify

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "font_resizify_prefs")

class FontScalePreference(private val context: Context) {
    companion object {
        private val FONT_SCALE_KEY = floatPreferencesKey("font_scale")
        private const val DEFAULT_FONT_SCALE = 1.0f
    }

    val fontScale: Flow<Float> = context.dataStore.data
        .map { preferences ->
            preferences[FONT_SCALE_KEY] ?: DEFAULT_FONT_SCALE
        }

    suspend fun saveFontScale(scale: Float) {
        context.dataStore.edit { preferences ->
            preferences[FONT_SCALE_KEY] = scale
        }
    }
}
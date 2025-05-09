package com.example.km5mobile.data.theme

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.km5mobile.domain.theme.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.datastore by preferencesDataStore(name = "theme_prefs")

private val KEY_THEME = stringPreferencesKey("app_theme")

class ThemePrefs(private val ctx: Context) {

    fun observe(): Flow<AppTheme> =
        ctx.datastore.data.map { p ->
            AppTheme.valueOf(p[KEY_THEME] ?: AppTheme.SYSTEM.name)
        }

    suspend fun save(theme: AppTheme) {
        ctx.datastore.edit { it[KEY_THEME] = theme.name }
    }
}

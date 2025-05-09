package com.example.km5mobile.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.km5mobile.domain.theme.AppTheme

//enum class AppTheme { SYSTEM, LIGHT, DARK }

private val LightColors = lightColorScheme()
private val DarkColors  = darkColorScheme()

@Composable
fun KM5Theme(theme: AppTheme, content: @Composable () -> Unit) {
    val colors = when (theme) {
        AppTheme.DARK   -> DarkColors
        AppTheme.LIGHT  -> LightColors
        AppTheme.SYSTEM -> if (androidx.compose.foundation.isSystemInDarkTheme()) DarkColors else LightColors
    }
    MaterialTheme(
        colorScheme = colors,
        typography  = MaterialTheme.typography,
        content     = content
    )
}

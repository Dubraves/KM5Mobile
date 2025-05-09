package com.example.km5mobile.domain.theme

import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    val theme: Flow<AppTheme>
    suspend fun setTheme(t: AppTheme)
}

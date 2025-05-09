package com.example.km5mobile.data.theme

import com.example.km5mobile.domain.theme.AppTheme
import com.example.km5mobile.domain.theme.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeRepositoryImpl @Inject constructor(
    private val prefs: ThemePrefs
) : ThemeRepository {
    override val theme: Flow<AppTheme> = prefs.observe()
    override suspend fun setTheme(t: AppTheme) = prefs.save(t)
}

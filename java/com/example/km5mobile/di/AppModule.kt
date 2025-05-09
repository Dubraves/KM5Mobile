package com.example.km5mobile.di

import android.content.Context
import com.example.km5mobile.data.local.ThemePrefs      // ← добавили
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideThemePrefs(@ApplicationContext ctx: Context) = ThemePrefs(ctx)
}

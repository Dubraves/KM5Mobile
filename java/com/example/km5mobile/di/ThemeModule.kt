package com.example.km5mobile.di

import android.content.Context
import com.example.km5mobile.data.theme.ThemePrefs
import com.example.km5mobile.data.theme.ThemeRepositoryImpl
import com.example.km5mobile.domain.theme.ThemeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ThemeModule {
    @Binds
    abstract fun bindThemeRepo(impl: ThemeRepositoryImpl): ThemeRepository

    companion object {
        @Provides @Singleton
        fun providePrefs(@ApplicationContext ctx: Context) = ThemePrefs(ctx)
    }
}

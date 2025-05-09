package com.example.km5mobile.di

import android.content.Context
import com.example.km5mobile.data.template.TemplatePrefs
import com.example.km5mobile.data.template.TemplateRepositoryImpl
import com.example.km5mobile.domain.template.TemplateRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class TemplateModule {

    /** Связываем интерфейс с реализацией */
    @Binds
    @Singleton
    abstract fun bindTemplateRepo(
        impl: TemplateRepositoryImpl
    ): TemplateRepository

    companion object {

        /** Выдаём DataStore‑обёртку */
        @Provides
        @Singleton
        fun provideTemplatePrefs(
            @ApplicationContext ctx: Context
        ): TemplatePrefs = TemplatePrefs(ctx)
    }
}

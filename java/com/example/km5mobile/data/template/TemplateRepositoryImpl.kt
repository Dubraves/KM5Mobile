package com.example.km5mobile.data.template

import com.example.km5mobile.domain.template.TemplateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TemplateRepositoryImpl @Inject constructor(
    private val prefs: TemplatePrefs
) : TemplateRepository {
    override val state: Flow<TemplatePrefs.TemplateState> = prefs.observe()
    override suspend fun save(state: TemplatePrefs.TemplateState) = prefs.save(state)
    override suspend fun reset() = prefs.reset()
}

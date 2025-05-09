package com.example.km5mobile.domain.template

import com.example.km5mobile.data.template.TemplatePrefs
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {
    val state: Flow<TemplatePrefs.TemplateState>
    suspend fun save(state: TemplatePrefs.TemplateState)
    suspend fun reset()
}

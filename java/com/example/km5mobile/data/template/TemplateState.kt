package com.example.km5mobile.data.template

import com.example.km5mobile.domain.template.*

/**
 * UI‑состояние экрана редактирования шаблона,
 * которое хранится в DataStore.
 */
data class TemplateState(
    val device:  DeviceType,
    val report:  ReportType,
    val enabled: Set<String>
)

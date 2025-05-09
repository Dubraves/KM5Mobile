package com.example.km5mobile.data.template

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.km5mobile.domain.template.DeviceType
import com.example.km5mobile.domain.template.ReportType
import com.example.km5mobile.domain.template.TemplateField
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.datastore by preferencesDataStore(name = "template_prefs")

private val KEY_DEVICE  = stringPreferencesKey("tpl_device")
private val KEY_REPORT  = stringPreferencesKey("tpl_report")
private val KEY_ENABLED = stringPreferencesKey("tpl_enabled")

class TemplatePrefs(private val ctx: Context) {

    fun observe(): Flow<TemplateState> = ctx.datastore.data.map { p ->
        val dev = DeviceType.valueOf(p[KEY_DEVICE] ?: DeviceType.KM5_1.name)
        val rep = ReportType.valueOf(p[KEY_REPORT] ?: ReportType.DAILY.name)
        val set = p[KEY_ENABLED]?.let { TemplateField.decode(it) } ?: TemplateField.defaultSet()
        TemplateState(dev, rep, set)
    }

    suspend fun save(st: TemplateState) =
        ctx.datastore.edit { p ->
            p[KEY_DEVICE]  = st.device.name
            p[KEY_REPORT]  = st.report.name
            p[KEY_ENABLED] = TemplateField.encode(st.enabled)
        }

    suspend fun reset() = save(
        TemplateState(DeviceType.KM5_1, ReportType.DAILY, TemplateField.defaultSet())
    )
}

/** UI‑состояние, хранимое в DataStore */
data class TemplateState(
    val device: DeviceType,
    val report: ReportType,
    val enabled: Set<String>
)

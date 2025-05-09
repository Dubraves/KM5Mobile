package com.example.km5mobile.ui.screen.template

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.km5mobile.data.template.TemplatePrefs
import com.example.km5mobile.domain.template.DeviceType
import com.example.km5mobile.domain.template.ReportType
import com.example.km5mobile.domain.template.TemplateField
import com.example.km5mobile.domain.template.TemplateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val repo: TemplateRepository
) : ViewModel() {

    private val _state = MutableStateFlow(
        TemplatePrefs.TemplateState(
            DeviceType.KM5_1,
            ReportType.DAILY,
            TemplateField.defaultSet()
        )
    )
    val state: StateFlow<TemplatePrefs.TemplateState> = _state

    init {
        viewModelScope.launch { repo.state.collect { _state.value = it } }
    }

    fun switchDevice(dt: DeviceType) =
        _state.update { it.copy(device = dt) }

    fun switchReport(rt: ReportType) =
        _state.update { it.copy(report = rt) }

    fun toggleField(field: TemplateField) =
        _state.update { st ->
            val set = st.enabled.toMutableSet()
            if (field.name in set) set.remove(field.name) else set.add(field.name)
            st.copy(enabled = set)
        }

    fun save() = viewModelScope.launch { repo.save(_state.value) }
    fun reset() = viewModelScope.launch { repo.reset() }
}

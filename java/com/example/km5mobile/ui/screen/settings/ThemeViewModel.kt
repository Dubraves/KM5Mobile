package com.example.km5mobile.ui.screen.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.km5mobile.domain.theme.AppTheme
import com.example.km5mobile.domain.theme.ThemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val repo: ThemeRepository
) : ViewModel() {

    val theme: StateFlow<AppTheme> =
        repo.theme.stateIn(viewModelScope, kotlinx.coroutines.flow.SharingStarted.Eagerly, AppTheme.SYSTEM)

    fun setTheme(t: AppTheme) = viewModelScope.launch { repo.setTheme(t) }
}

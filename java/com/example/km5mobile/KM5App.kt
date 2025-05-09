package com.example.km5mobile

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.km5mobile.domain.theme.AppTheme
import com.example.km5mobile.navigation.Routes
import com.example.km5mobile.ui.screen.HomeScreen
import com.example.km5mobile.ui.screen.SettingsScreen
import com.example.km5mobile.ui.theme.KM5Theme
import com.example.km5mobile.ui.components.StubScreen
import com.example.km5mobile.ui.screen.settings.ThemeViewModel
import com.example.km5mobile.ui.screen.template.TemplateScreen

@Composable
fun KM5App() {
    val themeViewModel = hiltViewModel<ThemeViewModel>()
    val currentTheme by themeViewModel.theme.collectAsState(initial = AppTheme.SYSTEM)

    KM5Theme(theme = currentTheme) {
        val nav = rememberNavController()
        NavHost(nav, startDestination = Routes.Home) {
            composable(Routes.Home) {
                HomeScreen(
                    onLoadClick = { nav.navigate(Routes.Load) },
                    onDbClick = { nav.navigate(Routes.Database) },
                    onSettingsClick = { nav.navigate(Routes.Settings) }
                )
            }
            composable(Routes.Settings) {
                SettingsScreen(
                    onBackClick      = { nav.popBackStack() },
                    onTemplatesClick = { nav.navigate(Routes.Template) }
                )
            }
            composable(Routes.Template) {
                TemplateScreen(onBack = { nav.popBackStack() })
            }

            /* пока оставляем заглушки */
            composable(Routes.Load)     { StubScreen("Считывание данных") }
            composable(Routes.Database) { StubScreen("База данных") }
            composable(Routes.Template) { StubScreen("Шаблоны") }
            composable(Routes.Report)   { StubScreen("Просмотр отчёта") }
        }
    }
}

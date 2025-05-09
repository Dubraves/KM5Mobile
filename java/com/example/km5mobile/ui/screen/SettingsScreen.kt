package com.example.km5mobile.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.km5mobile.domain.theme.AppTheme
import com.example.km5mobile.ui.screen.settings.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onTemplatesClick: () -> Unit,
) {
    val vm: SettingsViewModel = hiltViewModel()
    val current by vm.theme.collectAsState()

    var aboutDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Настройки") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            /* ---------- Выбор темы ---------- */
            var expanded by remember { mutableStateOf(false) }

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
            ) {
                OutlinedTextField(
                    readOnly = true,
                    value = title(current),
                    onValueChange = {},
                    label = { Text("Выбор темы") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    AppTheme.values().forEach { t ->
                        DropdownMenuItem(
                            text = { Text(title(t)) },
                            onClick = {
                                expanded = false
                                vm.setTheme(t)
                            }
                        )
                    }
                }
            }

            /* ---------- Пользовательские шаблоны ---------- */
            Button(
                onClick = onTemplatesClick,
                modifier = Modifier.fillMaxWidth()
            ) { Text("Настройка пользовательских шаблонов") }

            /* ---------- О программе ---------- */
            OutlinedButton(
                onClick = { aboutDialog = true },
                modifier = Modifier.fillMaxWidth()
            ) { Text("О программе") }
        }
    }

    if (aboutDialog) {
        AlertDialog(
            onDismissRequest = { aboutDialog = false },
            confirmButton = {
                TextButton(onClick = { aboutDialog = false }) { Text("OK") }
            },
            title = { Text("KM5Mobile 0.1.0") },
            text = {
                Text(
                    "Приложение для считывания данных с теплосчётчиков серии КМ‑5.\n" +
                            "Контакт: support@example.com"
                )
            }
        )
    }
}

private fun title(t: AppTheme) = when (t) {
    AppTheme.SYSTEM -> "Системная"
    AppTheme.LIGHT  -> "Светлая"
    AppTheme.DARK   -> "Тёмная"
}

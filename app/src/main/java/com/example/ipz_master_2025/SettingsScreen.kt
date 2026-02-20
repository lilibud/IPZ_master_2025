package com.example.ipz_master_2025

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onBack: () -> Unit
) {
    var isEnglish by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = if (isEnglish) "Settings" else "Налаштування",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(if (isEnglish) "Dark theme" else "Темна тема")
            Switch(
                checked = isDarkTheme,
                onCheckedChange = onThemeChange
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("English")
            Switch(
                checked = isEnglish,
                onCheckedChange = { isEnglish = it }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onBack) {
            Text(if (isEnglish) "Back" else "Назад")
        }
    }
}
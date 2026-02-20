package com.example.ipz_master_2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.ipz_master_2025.ui.theme.IPZ_master_2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var showOnboarding by remember { mutableStateOf(true) }
            var showSettings by remember { mutableStateOf(false) }
            var isDarkTheme by remember { mutableStateOf(false) }

            IPZ_master_2025Theme(
                darkTheme = isDarkTheme
            ) {

                when {
                    showOnboarding -> {
                        OnboardingScreen(
                            onContinue = { showOnboarding = false }
                        )
                    }

                    showSettings -> {
                        SettingsScreen(
                            isDarkTheme = isDarkTheme,
                            onThemeChange = { isDarkTheme = it },
                            onBack = { showSettings = false }
                        )
                    }

                    else -> {
                        ChatScreen(
                            onOpenSettings = { showSettings = true }
                        )
                    }
                }
            }
        }
    }
}
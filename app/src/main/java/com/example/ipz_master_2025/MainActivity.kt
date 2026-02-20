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
            IPZ_master_2025Theme {

                var showOnboarding by remember { mutableStateOf(true) }

                if (showOnboarding) {
                    OnboardingScreen(
                        onContinue = { showOnboarding = false }
                    )
                } else {
                    ChatScreen()
                }

            }
        }
    }
}
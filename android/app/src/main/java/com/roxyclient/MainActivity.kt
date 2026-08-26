package com.roxyclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.roxyclient.ui.screens.MainMenuScreen
import com.roxyclient.ui.theme.RoxyClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoxyClientTheme {
                MainMenuScreen()
            }
        }
    }
}

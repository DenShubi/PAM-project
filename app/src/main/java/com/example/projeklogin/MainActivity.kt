package com.example.projeklogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projeklogin.ui.theme.ProjekLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekLoginTheme {
                ProfileScreen() //Ganti sesuai mau nampilin page yang mana
            }
        }
    }
}

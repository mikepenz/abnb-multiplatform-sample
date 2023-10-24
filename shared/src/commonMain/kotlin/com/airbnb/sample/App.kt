package com.airbnb.sample

import androidx.compose.runtime.Composable
import com.airbnb.sample.navigation.AppNavigation
import com.airbnb.sample.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        AppNavigation()
    }
}

expect fun getPlatformName(): String
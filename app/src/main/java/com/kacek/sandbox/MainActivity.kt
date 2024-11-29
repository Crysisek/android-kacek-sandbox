package com.kacek.sandbox

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kacek.theme.AppTheme
import com.kacek.ui.basefeature.BaseScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenHandler()
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BaseScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    private fun splashScreenHandler() {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isAppReady.value
            }
            setOnExitAnimationListener { splashScreenView ->
                ObjectAnimator.ofFloat(
                    splashScreenView.view,
                    View.ALPHA,
                    1f,
                    0f,
                ).apply {
                    duration = 500L
                }.run {
                    doOnEnd { splashScreenView.remove() }
                    start()
                }
            }
        }
    }
}

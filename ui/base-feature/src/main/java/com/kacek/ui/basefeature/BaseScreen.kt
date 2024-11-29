package com.kacek.ui.basefeature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kacek.theme.AppTheme

@Composable
fun BaseScreen(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary))
}

@Preview(showBackground = true)
@Composable
fun BaseScreenPreview() {
    AppTheme {
        BaseScreen()
    }
}

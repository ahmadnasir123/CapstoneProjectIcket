package com.C23PS326.icket.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SectionText(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}
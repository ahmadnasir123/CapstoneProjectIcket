package com.C23PS326.icket.presentation.data_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

import com.C23PS326.icket.ui.theme.ICKETTheme

//@Composable
//fun DataScreen(
//    dataViewModel: DataViewModel = viewModel()
//){
//    val getData = dataViewModel.state.value
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(text = getData.description)
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun JetPlayerPreview() {
//    ICKETTheme {
//        DataScreen()
//    }
//}
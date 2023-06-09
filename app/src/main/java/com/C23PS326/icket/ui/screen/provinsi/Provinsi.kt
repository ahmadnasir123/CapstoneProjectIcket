package com.C23PS326.icket.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.components.ProvinsiListItem
import com.C23PS326.icket.ui.screen.provinsi.ProvinsiViewModel

@Composable
fun Provinsi(
    modifier: Modifier = Modifier,
    viewModel: ProvinsiViewModel = viewModel(factory = ViewModelFactory(Repository())),
    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getProvinsi()
            }
            is UiState.Success -> {
                ProvinsiContent(
                    orderProvinsi = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun ProvinsiContent(
    orderProvinsi: List<OrderProvinsi>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            text = "Provinsi",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Box(modifier = modifier) {
            val listState = rememberLazyListState()

            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(orderProvinsi) {data ->
                    ProvinsiListItem(
                        id = data.provinsi.provinsiId,
                        name = data.provinsi.name,
                        ibukota = data.provinsi.ibukota,
                        navigateToDetail = navigateToDetail
                    )
                }
            }

        }
    }
}
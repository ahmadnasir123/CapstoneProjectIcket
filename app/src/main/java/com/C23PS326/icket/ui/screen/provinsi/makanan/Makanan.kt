package com.C23PS326.icket.ui.screen.provinsi.makanan

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.C23PS326.icket.model.makanan.OrderMakanan
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.components.MakananItem
import com.C23PS326.icket.ui.components.ProvinsiListItem

@Composable
fun Makanan(
    modifier: Modifier = Modifier,
    viewModel: MakananViewModel = viewModel(factory = ViewModelFactory(Repository())),
    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getMakanan()
            }
            is UiState.Success -> {
                MakananContent(
                    orderMakanan = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {}
        }
    }
}


@Composable
fun MakananContent(
    orderMakanan: List<OrderMakanan>,
    modifier: Modifier,
    navigateToDetail: (Long) -> Unit,
){
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            text = "Makanan",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(orderMakanan) { data ->
                MakananItem(
                    id = data.makanan.makananId,
                    name = data.makanan.name,
                    photo = data.makanan.photo,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}
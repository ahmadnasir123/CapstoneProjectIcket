package com.C23PS326.icket.ui.screen.categori.wisata

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.categori.wisata.OrderWisataCategori
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.components.categori.CategoyListItem

@Composable
fun CategoriWisataScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoriWisataViewModel = viewModel(factory = ViewModelFactory(Repository())),
    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getWisataCategori()
            }
            is UiState.Success -> {
                CategoriContent(
                    orderCategori = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun CategoriContent(
    orderCategori: List<OrderWisataCategori>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {

    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showBtn: Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(orderCategori) {data ->
                CategoyListItem(
                    id = data.wisatacategori.wisataId,
                    name = data.wisatacategori.name,
                    image = data.wisatacategori.image,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}
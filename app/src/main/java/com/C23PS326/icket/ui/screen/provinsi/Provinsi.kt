package com.C23PS326.icket.ui.screen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.components.ProvinsiListItem
import com.C23PS326.icket.ui.components.ScrollToTopButton
import com.C23PS326.icket.ui.navigation.Screen
import com.C23PS326.icket.ui.screen.provinsi.ProvinsiViewModel
import kotlinx.coroutines.launch

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
            items(orderProvinsi) {data ->
                ProvinsiListItem(
                    id = data.provinsi.provinsiId,
                    name = data.provinsi.name,
                    ibukota = data.provinsi.ibukota,
                    navigateToDetail = navigateToDetail
                )
            }
        }
        AnimatedVisibility(
            visible = showBtn,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp, end = 30.dp)
                .align(Alignment.BottomEnd)
        ) {
            ScrollToTopButton(
                onClick = {
                    scope.launch{
                        listState.scrollToItem(index = 0)
                    }
                }
            )
        }
    }
}
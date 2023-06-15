package com.C23PS326.icket.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.C23PS326.icket.R
import com.C23PS326.icket.di.Injection
import com.C23PS326.icket.model.OrderBudaya
import com.C23PS326.icket.model.Budaya
import com.C23PS326.icket.model.OrderWisata
import com.C23PS326.icket.model.dummyCategory
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.components.*
import com.C23PS326.icket.ui.screen.provinsi.listitemwisata.WisataViewModel
import com.C23PS326.icket.ui.theme.ICKETTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    viewModel2: ShowWisataViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
    navigateToDetailWisata: (Long) -> Unit,
) {
    Column(
    ) {
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getBudaya()
                }
                is UiState.Success -> {
                    HomeContent(
                        orderBudaya = uiState.data,
                        modifier = modifier,
                        navigateToDetail = navigateToDetail,
                    )
                }
                is UiState.Error -> {}
            }
        }
        viewModel2.uIState.collectAsState(initial = UiState.Loading).value.let { uIstate ->
            when (uIstate){
                is UiState.Loading -> {
                    viewModel2.getWisata()
                }
                is UiState.Success -> {
                    HomeContent2(
                        orderWisata = uIstate.data,
                        modifier = modifier,
                        navigateToDetailWisata = navigateToDetailWisata
                    )
                }
                is UiState.Error -> {}
            }
        }
    }

}



@Composable
fun HomeContent(
    orderBudaya: List<OrderBudaya>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,

    ) {
    Column(
        modifier = modifier
            .verticalScroll((rememberScrollState()))
    ) {
        Banner()
        CategoryRow()
        Column(
            modifier = Modifier.padding(start = 24.dp, bottom = 6.dp)
        ) {
            Text(
                text = stringResource(R.string.section_populer_budaya),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Box(modifier = modifier) {
            val scope = rememberCoroutineScope()
            val listState = rememberLazyListState()
            val showBtn: Boolean by remember {
                derivedStateOf { listState.firstVisibleItemIndex > 0 }
            }

            LazyRow(
                state = listState,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(orderBudaya) { data ->
                    BudayaListItem(
                        id = data.budaya.budayaId,
                        name = data.budaya.name,
                        image = data.budaya.image,
                        navigateToDetail = navigateToDetail
                    )
                }
            }
        }
      Spacer(modifier = modifier.height(10.dp))
    }
}

@Composable
fun HomeContent2(
    orderWisata: List<OrderWisata>,
    modifier: Modifier = Modifier,
    navigateToDetailWisata: (Long) -> Unit,
){
    Column(
        modifier =modifier
            .verticalScroll((rememberScrollState()))
    ){
        Column(
            modifier = Modifier.padding(start = 24.dp, bottom = 8.dp, top = 18.dp)
        ) {
            Text(
                text = stringResource(R.string.section_populer_wisata),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Box(modifier = modifier) {
            val scope = rememberCoroutineScope()
            val listState = rememberLazyListState()
            val showBtn: Boolean by remember {
                derivedStateOf { listState.firstVisibleItemIndex > 0 }
            }

            LazyRow(
                state = listState,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(orderWisata) { data ->
                    WisataListItem(
                        id = data.wisata.wisataId,
                        name = data.wisata.name,
                        image = data.wisata.image,
                        navigateToDetail = navigateToDetailWisata
                    )
                }
            }
        }
    }
}


@Composable
fun Banner(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier

) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.padding(16.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    ICKETTheme {
        CategoryRow()

    }
}
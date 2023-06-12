package com.C23PS326.icket.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.C23PS326.icket.JetIcketApp
import com.C23PS326.icket.R
import com.C23PS326.icket.di.Injection
import com.C23PS326.icket.model.BottomBarItem
import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.Rekomendasi
import com.C23PS326.icket.model.budaya.RekomendasiDataBudaya
import com.C23PS326.icket.model.budaya.RekomendasiDataBudaya.rekomendata
import com.C23PS326.icket.model.dummyCategory
import com.C23PS326.icket.model.wisata.RekomendasiDataWisata.wisatadata
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.components.*
import com.C23PS326.icket.ui.theme.ICKETTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllRewards()
            }
            is UiState.Success -> {
                HomeContent(
                    orderReward = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                    listMenu = wisatadata,

                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    orderReward: List<OrderRekomendasi>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
    listMenu: List<Rekomendasi>,
) {
    Column(
        modifier =modifier
            .verticalScroll((rememberScrollState()))
    ) {
        Banner()
        CategoryRow()
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = stringResource(R.string.section_populer_budaya,

                    )
            )

        }
        WisataRow(wisatadata)
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = stringResource(R.string.section_populer_wisata,

                    )
            )
        }
        BudayaRow(rekomendata)
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
fun BudayaRow(
    listMenu: List<Rekomendasi>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.name }) { menu ->
            BudayaItem(menu)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BudayaRowPreview() {
    ICKETTheme {
        BudayaRow(rekomendata)
    }
}

@Composable
fun WisataRow(
    listMenu: List<Rekomendasi>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.name }) { menu ->
            WisataItem(menu)
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
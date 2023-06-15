package com.C23PS326.icket.ui.screen.provinsi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.C23PS326.icket.model.budaya.Budaya
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.theme.ICKETTheme
import com.C23PS326.icket.R
import com.C23PS326.icket.di.Injection
import com.C23PS326.icket.ui.screen.provinsi.listItem.BudayaViewModel

@Composable
fun BudayaScreen(
    budayaId: Long,
    viewModel: BudayaViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateBack: () -> Unit,
    ) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getBudaya2(budayaId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.budaya,
                    onBackClick = navigateBack,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    data: Budaya,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .clickable { onBackClick() }
        ) {
            Box() {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onBackClick() }
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ){
                AsyncImage(
                    model = data.image,
                    contentDescription = "Photo Budaya",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    modifier = modifier
                        .height(350.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = data.name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                    )
                    Text(
                        text = data.desc,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DetailBudayaPreview() {
    ICKETTheme {
        DetailContent(
            data = Budaya(
                1,
                "Wayang Kulit ",
                "\n" +
                        "Wayang kulit adalah sebuah seni pertunjukan tradisional Indonesia yang memiliki sejarah panjang dan kaya. Seni wayang kulit diperkirakan telah ada sejak sekitar abad ke-10 Masehi dan terus berkembang hingga saat ini. " +
                        "\n" +"Pertunjukan wayang kulit melibatkan dalang yang mengendalikan boneka-boneka kulit yang diproyeksikan melalui layar putih. Wayang kulit memiliki akar budaya yang kuat dan dipengaruhi oleh berbagai tradisi, seperti Hindu, Budha, dan Islam. Kisah-kisah yang diceritakan dalam wayang kulit sering kali diambil dari epik-epik seperti Ramayana dan Mahabharata, serta cerita-cerita rakyat Indonesia. Selain sebagai hiburan, pertunjukan wayang kulit juga memiliki makna religius dan pendidikan, dengan nilai-nilai moral yang disampaikan melalui dialog dan adegan-a degan dalam pertunjukan. Wayang kulit menjadi bagian penting dalam mempertahankan dan melestarikan warisan budaya dan sejarah Indonesia, serta sebagai sarana ekspresi seni yang unik dan memukau.",
                "https://pelayananpublik.id/wp-content/uploads/2020/04/Screenshot_20200416-175344_1.jpg"
            ),
            onBackClick = { }
        )
    }
}
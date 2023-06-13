package com.C23PS326.icket.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.C23PS326.icket.R
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.Rekomendasi
import com.C23PS326.icket.ui.ViewModelFactory
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.screen.provinsi.detail.DetailViewModel
import com.C23PS326.icket.ui.theme.*

@Composable
fun DetailProvinsiScreen(
    provinsiId: Long,
    viewModel: DetailViewModel = viewModel(factory = ViewModelFactory(Repository())),
    navigateBack: () -> Unit,

    ){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getProvinsiId(provinsiId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.rekomendasi,
                    onBackClick = navigateBack,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    data: Rekomendasi,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
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
            ) {
                AsyncImage(
                    model = data.image,
                    contentDescription = "Character Image",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    modifier = modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = data.name,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Justify,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = data.desc,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.greenColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_wisata), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_wisata),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_wisata),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }

                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.yellowColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_makanan), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_makanan),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_makanan),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }

                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.pinkColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_tarian), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_tarian),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_tarian),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }

                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.redColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_senjata), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_senjata),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_senjata),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.blueColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_lagu), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_lagu),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_lagu),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }

                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.greenColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_rumah), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_rumah_adat),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_rumah_adat),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }

                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.purpleColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_pakaian), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_pakaian),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_pakaian),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }

                    Button(
                        onClick = { /* Handle button 3 click */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.darkpurpleColor)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_tradisi), // Replace with your drawable resource
                                contentDescription = stringResource(R.string.txt_tradisi),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Text(
                                text = stringResource(R.string.txt_tradisi),
                                fontSize = 10.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailProvinsiPreview(){
    ICKETTheme() {
        DetailContent(
            data = Rekomendasi(
                1,
                "Bali",
                "Provinsi Bali adalah sebuah provinsi di Indonesia yang terletak di Pulau Bali. Bali terkenal sebagai salah satu destinasi pariwisata terbaik di dunia dengan keindahan alamnya yang menakjubkan, budaya yang kaya, dan pantai-pantai yang indah. Ibukota provinsi ini adalah Kota Denpasar. Bali memiliki sejumlah objek wisata populer seperti Pantai Kuta, Ubud yang terkenal dengan seni dan budayanya, Tanah Lot yang terletak di atas laut, dan Pura Besakih sebagai pura terbesar dan terpenting di Bali. Selain itu, Bali juga memiliki tradisi dan upacara adat yang khas seperti Upacara Kuningan, Ngaben (upacara kremasi), dan Ogoh-ogoh pada hari raya Nyepi. Bali juga terkenal dengan kerajinan tangan seperti ukiran kayu, batik, dan perak. Dengan keunikan dan keindahannya, Bali menjadi tujuan wisata yang sangat populer baik bagi wisatawan lokal maupun mancanegara.",
                "https://a.cdn-hotels.com/gdcs/production143/d1112/c4fedab1-4041-4db5-9245-97439472cf2c.jpg"
            ),
            onBackClick = { }
        )
    }
}
package com.C23PS326.icket.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.C23PS326.icket.JetIcketApp
import com.C23PS326.icket.model.dummyCategory
import com.C23PS326.icket.ui.components.CategoryItem
import com.C23PS326.icket.ui.theme.ICKETTheme
import com.C23PS326.icket.R
import com.C23PS326.icket.model.Rekomendasi

@Composable
fun DetailProvinsiScreen(){

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
                modifier = Modifier.padding(24.dp)
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
            }
        }
        CategoryBox()
    }
}

@Composable
fun CategoryBox(
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(dummyCategory, key = { it.textCategory }) { category ->
                CategoryItem(category)
            }
        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun CategoryBoxPreview() {
//    ICKETTheme {
//        CategoryBox()
//    }
//}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailProvinsiPreview(){
    ICKETTheme() {
        DetailContent(
            data = Rekomendasi(
                1,
                "Wayang Kulit",
                "Wayang kulit merupakan seni tradisional Indonesia yang lahir, hidup, dan berkembang terutama di masyarakat Jawa. Dalam pertunjukannya, wayang kulit bukan hanya sekadar hiburan, tetapi juga menyimpan nilai spiritual dan filosofis yang mendalam. Melalui media kulit kerbau, seorang dalang memainkan karakter-karakter dalam cerita wayang, disertai dengan musik gamelan dan nyanyian pesinden.\n" +
                        "\n" +
                        "Setiap bagian pementasan memiliki simbol dan makna filosofis yang kuat, sambil mengajarkan budi pekerti yang luhur serta menyampaikan pesan sosial melalui adegan-adegan yang lucu. Wayang kulit, sebagai embrio dari berbagai jenis wayang lainnya, memiliki sejarah yang panjang dan telah menyebar ke berbagai wilayah di Indonesia. Dengan keunikan dan kekayaannya, wayang kulit diakui sebagai warisan budaya dunia oleh UNESCO.\n",
                "https://asset.kompas.com/crops/LeDT4hIHS0zJ5Bq7Yu6dhLp_ysM=/16x0:691x450/750x500/data/photo/2022/09/09/631af8ce3c329.jpg"
            ),
            onBackClick = { }
        )
    }
}
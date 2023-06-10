package com.C23PS326.icket.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.C23PS326.icket.model.Rekomendasi
import com.C23PS326.icket.R

@Composable
fun BudayaItem(
    budaya: Rekomendasi,
    modifier: Modifier = Modifier,
) {
    Card (
        modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp),

    ){
        Column {
            AsyncImage(
                model = budaya.image,
                contentDescription = stringResource(R.string.section_populer_budaya),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = budaya.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BudayaItemPreview() {
    MaterialTheme {
        BudayaItem(
            budaya =  Rekomendasi(
                1,
                "Wayang Kulit",
                "Wayang kulit merupakan seni tradisional Indonesia yang lahir, hidup, dan berkembang terutama di masyarakat Jawa. Dalam pertunjukannya, wayang kulit bukan hanya sekadar hiburan, tetapi juga menyimpan nilai spiritual dan filosofis yang mendalam. Melalui media kulit kerbau, seorang dalang memainkan karakter-karakter dalam cerita wayang, disertai dengan musik gamelan dan nyanyian pesinden.\n" +
                        "\n" +
                        "Setiap bagian pementasan memiliki simbol dan makna filosofis yang kuat, sambil mengajarkan budi pekerti yang luhur serta menyampaikan pesan sosial melalui adegan-adegan yang lucu. Wayang kulit, sebagai embrio dari berbagai jenis wayang lainnya, memiliki sejarah yang panjang dan telah menyebar ke berbagai wilayah di Indonesia. Dengan keunikan dan kekayaannya, wayang kulit diakui sebagai warisan budaya dunia oleh UNESCO.\n",
                "https://asset.kompas.com/crops/LeDT4hIHS0zJ5Bq7Yu6dhLp_ysM=/16x0:691x450/750x500/data/photo/2022/09/09/631af8ce3c329.jpg"
            ),

            modifier = Modifier.padding(8.dp)

        )
    }
}
package com.C23PS326.icket.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.C23PS326.icket.R
import com.C23PS326.icket.model.Budaya

@Composable
fun WisataItem(
    wisata: Budaya,
    modifier: Modifier = Modifier,
) {
    Card (
        modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp),

        ){
        Column {
            AsyncImage(
                model = wisata.image,
                contentDescription = stringResource(R.string.section_populer_wisata),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .size(100.dp)
            )
            Column( modifier = Modifier.absolutePadding(left = 16.dp, bottom = 4.dp, top = 4.dp)

            ) {
                Text(
                    text = wisata.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.Bold
                    ),
                )

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WisataItemPreview() {
    MaterialTheme {
        WisataItem(
            wisata =    Budaya(
                4,
                "Nusa Penida",
                "Nusa Penida adalah sebuah pulau (=nusa) bagian dari negara Republik Indonesia yang terletak di sebelah tenggara Bali yang dipisahkan oleh Selat Badung. Di dekat pulau ini terdapat juga pulau-pulau kecil lainnya yaitu Nusa Ceningan dan Nusa Lembongan. Perairan pulau Nusa Penida terkenal dengan kawasan selamnya di antaranya terdapat di Crystal Bay, Manta Point, Batu Meling, Batu Lumbung, Batu Abah, Toyapakeh dan Malibu Point.",
                "https://id.nusa-penida.info/uploads/s/q/t/7/qt7iugfk1ixz/img/full_59ZrrtR0.jpg"
            ),

            modifier = Modifier.absolutePadding(left = 16.dp, bottom = 4.dp, top = 4.dp)

        )
    }
}
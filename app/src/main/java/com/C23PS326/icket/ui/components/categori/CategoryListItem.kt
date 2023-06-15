package com.C23PS326.icket.ui.components.categori

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.C23PS326.icket.R

@Composable
fun CategoyListItem(
    id:Long,
    name: String,
    image: String,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    Card (
        modifier = modifier.width(140.dp)
            .clickable{navigateToDetail(id)},
        shape = RoundedCornerShape(8.dp),
    ){
        Column {
            AsyncImage(
                model = image,
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
                    text = name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    ),
                )

            }
        }
    }
}
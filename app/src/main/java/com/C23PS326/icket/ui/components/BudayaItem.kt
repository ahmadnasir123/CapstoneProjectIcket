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
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.stringResource
import com.C23PS326.icket.model.Category
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
fun MenuItemPreview() {
    MaterialTheme {
        BudayaItem(
            budaya = Category(R.drawable.menu2, "Hot Pumpkin Spice Latte Premium", "Rp 18.000"),
            modifier = Modifier.padding(8.dp)
        )
    }
}
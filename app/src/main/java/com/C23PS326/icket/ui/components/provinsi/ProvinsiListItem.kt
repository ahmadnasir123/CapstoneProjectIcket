package com.C23PS326.icket.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.C23PS326.icket.ui.screen.about.ScreenAbout
import com.C23PS326.icket.ui.theme.ICKETTheme

@Composable
fun ProvinsiListItem(
    id: Long,
    name: String,
    ibukota: String,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    Card(Modifier.padding(8.dp)) {
        Column(
            modifier = modifier.clickable{navigateToDetail(id)},
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp)
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = ibukota,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp)
            )
        }
    }
}
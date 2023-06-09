package com.C23PS326.icket.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.C23PS326.icket.R
import com.C23PS326.icket.model.Category
import com.C23PS326.icket.ui.theme.ICKETTheme

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(category.imageCategory),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
        )
        Text(
            text = stringResource(category.textCategory),
            fontSize = 10.sp,
            modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview(){
    ICKETTheme(){
        CategoryItem(
            category = Category(
                R.drawable.wisata,
                R.string.txt_wisata,
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}
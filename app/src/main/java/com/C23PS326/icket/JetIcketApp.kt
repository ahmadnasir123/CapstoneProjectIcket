package com.C23PS326.icket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.C23PS326.icket.ui.components.SearchBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import com.C23PS326.icket.model.dummyCategory
import com.C23PS326.icket.ui.components.CategoryItem
import com.C23PS326.icket.ui.theme.ICKETTheme

@Composable
fun JetIcketApp() {
    Column {
        Banner()
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
@Preview(showBackground = true)
fun CategoryRowPreview() {
    ICKETTheme() {
        CategoryRow()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryBoxPreview() {
    ICKETTheme {
    JetIcketApp()
    }
}


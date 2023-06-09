package com.C23PS326.icket.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.C23PS326.icket.model.dummyCategory
import com.C23PS326.icket.ui.components.CategoryItem
import com.C23PS326.icket.ui.theme.ICKETTheme

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

@Preview(showBackground = true)
@Composable
fun CategoryBoxPreview() {
    ICKETTheme {
        CategoryBox()
    }
}
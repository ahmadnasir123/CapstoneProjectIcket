package com.C23PS326.icket.ui.screen.about

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.C23PS326.icket.ui.screen.home.CategoryRow
import com.C23PS326.icket.ui.theme.ICKETTheme

@Composable
fun test(){
    Log.d("TAG", "Hello")
}

@Composable
@Preview(showBackground = true)
fun testPreview() {
    ICKETTheme {
        test()

    }
}
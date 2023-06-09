package com.C23PS326.icket


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.C23PS326.icket.navigation.NavigationGraph
import com.C23PS326.icket.ui.theme.ICKETTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    ICKETTheme{
                        JetIcketApp()
                 }
                NavigationGraph()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun JetPlayerPreview() {
    ICKETTheme {
        JetIcketApp()
    }
}
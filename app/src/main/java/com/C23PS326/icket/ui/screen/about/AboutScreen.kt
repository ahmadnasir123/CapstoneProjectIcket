package com.C23PS326.icket.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.C23PS326.icket.R
import com.C23PS326.icket.ui.theme.ICKETTheme


@Composable
fun AboutScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
) {

}

@Composable
fun Team(name: String, email: String, path: String) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.placeholder),
            contentDescription = "Logo Jetpack Compose",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(18.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "$name",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = "$email")
            Text(text = "$path")
        }
    }
}

@Preview (showBackground = true)
@Composable
fun TeamPreview(){
    ICKETTheme() {
        Team(name = "Ahmad Nasir", "nasir.ahmad@gmail.com", "Mobile Development")
    }
}

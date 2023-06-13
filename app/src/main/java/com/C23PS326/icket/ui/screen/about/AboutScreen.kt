package com.C23PS326.icket.ui.screen.about

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.C23PS326.icket.model.team.TeamData
import com.C23PS326.icket.ui.screen.home.CategoryRow
import com.C23PS326.icket.ui.theme.ICKETTheme
import com.C23PS326.icket.R

@Composable
fun ScreenAbout(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.txt_team),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(modifier = modifier) {
            LazyColumn {
                items(TeamData.teamdata, key = { it.teamId }) { team ->
                    TeamListItem(
                        name = team.name,
                        email = team.email,
                        path = team.path,
                        photoUrl = team.photo,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenAboutPreview() {
    ICKETTheme() {
        ScreenAbout()
    }
}


@Composable
fun TeamListItem(
    name: String,
    email: String,
    path: String,
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(2.dp)
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Column() {
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            Text(
                text = path,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
            Text(
                text = email,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamListItemPreview() {
    ICKETTheme() {
        TeamListItem(
            name = "M Aldiansyah Ali",
            path = "Mobile Development",
            email = "aldiansyahali717@gmail.com",
            photoUrl = "https://cdn-icons-png.flaticon.com/512/74/74472.png"
        )
    }
}
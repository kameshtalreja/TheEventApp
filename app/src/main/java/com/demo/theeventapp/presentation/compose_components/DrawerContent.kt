package com.demo.theeventapp.presentation.compose_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.demo.theeventapp.R


@Composable
fun DrawerContent(
    selectedItem: Int, onItemSelected: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(.65f)
            .fillMaxHeight()
            .background(Color.White)
            .statusBarsPadding()
    ) {
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_home), selected = selectedItem == R.string.menu_home, onClick = { onItemSelected(R.string.menu_home) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_agenda), selected = selectedItem == R.string.menu_agenda, onClick = { onItemSelected(R.string.menu_agenda) })
        DrawerItem(icon = Icons.Default.Person, text = stringResource(id = R.string.menu_speakers), selected = selectedItem == R.string.menu_speakers, onClick = { onItemSelected(R.string.menu_speakers) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_badge), selected = selectedItem == R.string.menu_badge, onClick = { onItemSelected(R.string.menu_badge) })
        DrawerItem(icon = Icons.Default.Place, text = stringResource(id = R.string.menu_venue), selected = selectedItem == R.string.menu_venue, onClick = { onItemSelected(R.string.menu_venue) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_brand), selected = selectedItem == R.string.menu_brand, onClick = { onItemSelected(R.string.menu_brand) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_videos), selected = selectedItem == R.string.menu_videos, onClick = { onItemSelected(R.string.menu_videos) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_questions), selected = selectedItem == R.string.menu_questions, onClick = { onItemSelected(R.string.menu_questions) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_voting), selected = selectedItem == R.string.menu_voting, onClick = { onItemSelected(R.string.menu_voting) })
        DrawerItem(icon = Icons.Default.Share, text = stringResource(id = R.string.menu_social), selected = selectedItem == R.string.menu_social, onClick = { onItemSelected(R.string.menu_social) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_survey), selected = selectedItem == R.string.menu_survey, onClick = { onItemSelected(R.string.menu_survey) })
        DrawerItem(icon = Icons.Default.Home, text = stringResource(id = R.string.menu_cme), selected = selectedItem == R.string.menu_cme, onClick = { onItemSelected(R.string.menu_cme) })

    }
}


@Composable
fun DrawerItem(icon: ImageVector, text: String, selected: Boolean, onClick: () -> Unit) {
    val selectedItemColor = Color(0xFF1fabe7)  // Color for the selected item
    val defaultItemColor = LocalContentColor.current  // Default color

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(24.dp),
            tint = if (selected) selectedItemColor else defaultItemColor
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text,
            color = if (selected) selectedItemColor else defaultItemColor
        )
    }
}
package com.demo.theeventapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.theeventapp.presentation.compose_components.EventCard
import com.demo.theeventapp.data.EventCardItem

@Composable
fun HomeScreen(innerPadding: PaddingValues = PaddingValues(16.dp), items: List<EventCardItem>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()

    ) {
        items(items.size) { index ->
            Box (modifier = Modifier.fillMaxSize()){
                EventCard(eventCardItem = items[index])

            }
        }
    }
}
package com.demo.theeventapp.presentation.compose_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.theeventapp.data.EventCardItem
import com.demo.theeventapp.R

@Preview
@Composable
fun EventCard(
    modifier: Modifier = Modifier
        .padding(bottom = 10.dp),

    eventCardItem: EventCardItem? = EventCardItem(
        R.drawable.social, backgroundColor = colorResource(
        id = R.color.one
    ))
) {
    Column (
        modifier = modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box {
            Image(
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = eventCardItem?.backgroundColor!!)
                    .width(150.dp),
                painter = painterResource(id = eventCardItem.drawableImage),
                contentDescription ="" )
        }
    }
}
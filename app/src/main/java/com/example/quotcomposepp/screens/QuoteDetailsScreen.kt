package com.example.quotcomposepp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotcomposepp.DataManager
import com.example.quotcomposepp.Model.QuotesModel


@Composable
fun QuotDetailsScreen(quotesModel: QuotesModel){

    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffF),
                        Color(0xFFE3E3E3)
                    )
                )
            ),
        contentAlignment = Alignment.Center,
    ) {

        Card(
            modifier = Modifier.padding(32.dp),
            elevation = CardDefaults.elevatedCardElevation(8.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(26.dp,24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    colorFilter= ColorFilter.tint(Color.Black),
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180F)
                        .background(Color.Transparent),
                    contentDescription = "Quote"
                )

                Text(
                    text = quotesModel.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )

                Spacer(modifier = Modifier.padding(4.dp))


                Text(
                    text = quotesModel.author,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )

            }
        }

    }
}
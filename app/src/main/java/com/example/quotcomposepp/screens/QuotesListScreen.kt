package com.example.quotcomposepp.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotcomposepp.DataManager
import com.example.quotcomposepp.Model.QuotesModel


@Composable
fun QuotesListScreen(data: Array<QuotesModel>, onClick:(quote:QuotesModel)-> Unit) {
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
            style=MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily.Default
        )
        Log.d("TAG","screen"+data.size)
        QuotesList(data = data, onClick)
    }
}
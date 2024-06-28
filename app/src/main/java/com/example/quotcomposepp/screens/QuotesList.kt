package com.example.quotcomposepp.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotcomposepp.Model.QuotesModel


@Composable
fun QuotesList(data: Array<QuotesModel>, onClick: (quote:QuotesModel)->Unit) {

    Log.d("TAG","List="+data.size)
    LazyColumn(content = {
        items(data) {
            QuotListItem(quotesModel = it,onClick)
        }
    })

}
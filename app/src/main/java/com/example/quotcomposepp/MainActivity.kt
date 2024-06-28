package com.example.quotcomposepp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quotcomposepp.screens.QuotDetailsScreen
import com.example.quotcomposepp.screens.QuotesListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.loadArrayFormFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if(DataManager.isDataLoaded.value){
        if(DataManager.currentPage.value==Pages.LISTING) {
            Log.d("TAG", "" + DataManager.data.size)
            QuotesListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let { QuotDetailsScreen(it) }
        }
    }else{
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)){
            Text(text = "Loading...",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}

enum class Pages(){
    LISTING,
    DETAIL
}
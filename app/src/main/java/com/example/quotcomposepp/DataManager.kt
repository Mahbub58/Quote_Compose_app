package com.example.quotcomposepp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotcomposepp.Model.QuotesModel
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {


    var currentPage= mutableStateOf(Pages.LISTING)
    var currentQuote :QuotesModel?= null

    var data= emptyArray<QuotesModel>()
    var isDataLoaded= mutableStateOf(false)

    fun loadArrayFormFile(context: Context){



        val inputStream= context.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer= ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val  json=String(buffer, Charsets.UTF_8)
        val gson= Gson()
        data=gson.fromJson(json,Array<QuotesModel>::class.java)

        isDataLoaded.value=true

    }



    fun switchPages(quote:QuotesModel?){
        if(currentPage.value==Pages.LISTING){
            currentQuote=quote
            currentPage.value=Pages.DETAIL
        }else{
            currentPage.value=Pages.LISTING
        }
    }
}
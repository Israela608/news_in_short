package com.example.newsinshort.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class NewsViewmodel @Inject constructor() : ViewModel(){

    init {
        Log.d(TAG,"Init block of NewsViewmodel")
    }

    companion object{
        const val TAG = "NewsViewmodel"
    }
}
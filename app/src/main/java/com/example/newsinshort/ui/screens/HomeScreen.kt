package com.example.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshort.ResourceState
import com.example.newsinshort.ui.components.Loader
import com.example.newsinshort.ui.viewmodel.NewsViewmodel

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsViewmodel: NewsViewmodel = hiltViewModel()
) {

    val newsRes by newsViewmodel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourceState.Success -> {

                val response = (newsRes as ResourceState.Success).data
                Log.d(TAG, "Inside_success ${response.status} = ${response.totalResults}")
            }

            is ResourceState.Error -> {
                val error = (newsRes as ResourceState.Error)
                Log.d(TAG, "Inside_Error $error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
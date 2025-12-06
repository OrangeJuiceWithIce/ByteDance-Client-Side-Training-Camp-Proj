package com.example.mynews.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mynews.ui.components.BottomNavBar
import com.example.mynews.ui.components.TabsSection
import com.example.mynews.ui.components.TopBar

@Composable
fun MainScreen(){
    Scaffold(
        topBar = { TopBar() },
        bottomBar = {BottomNavBar()},
    ) {
        padding->
        Column(
            modifier= Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFFF4D4F))
        ) {
            TabsSection()
            Box(
                modifier= Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF5F5F5))
            )
        }
    }
}
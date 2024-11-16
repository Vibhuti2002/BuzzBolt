package com.example.buzzbolt.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.buzzbolt.presentation.HomeScreen
import com.example.buzzbolt.presentation.SearchScreen
import com.example.buzzbolt.presentation.WeatherScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController= navController, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen()
        }
        composable(route = BottomBarScreen.Weather.route) {
            WeatherScreen()
        }
    }
}
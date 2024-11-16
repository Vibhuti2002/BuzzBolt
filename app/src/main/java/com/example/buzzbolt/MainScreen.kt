package com.example.buzzbolt
import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.buzzbolt.presentation.navgraph.BottomBarScreen
import com.example.buzzbolt.presentation.navgraph.BottomNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.Weather
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEachIndexed { _, item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = "Navigation Icon") },
                label = { item.title },
                selected = currentDestination?.hierarchy?.any {
                        it.route == item.route
                }==true,
                onClick = { navController.navigate(item.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                } }
            )
        }
    }
}
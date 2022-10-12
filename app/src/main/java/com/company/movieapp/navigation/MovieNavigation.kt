package com.company.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.company.movieapp.screens.home.HomeScreen
import com.company.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailsScreen.name+"/{movie}"
            , arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})) {
            backStackString ->
            DetailsScreen(navController = navController,
                backStackString.arguments?.getString("movie"))
        }
    }


}
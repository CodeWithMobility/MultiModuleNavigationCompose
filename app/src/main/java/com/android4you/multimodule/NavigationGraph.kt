package com.android4you.multimodule

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android4you.feature_home.FeatureHome
import com.android4you.feature_profile.FeatureProfile
import com.android4you.navigation.NavigationItem

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startLocation: String
) {
    NavHost(
        navController = navController,
        startDestination = startLocation
    ) {
        composable(
            route = NavigationItem.AppScreen.route
        ) {
            AppScreen(
                navigateTo = {
                    navController.navigate(it)
                }
            )
        }

        composable(
            route = NavigationItem.FeatureHome.route
        ) {
           FeatureHome(navigateTo = {
                navController.navigate(it
                ,
                    builder = {
                        // Add the popUpTo attribute to clear the back stack
                        popUpTo("app_screen") {
                            inclusive = true // Set to true if you want to remove the specified destination as well
                        }
                        // Optionally, specify other navigation options like singleTop or launchSingleTop if needed
                        launchSingleTop = true
                    })
            })
        }
//
//        composable(
//            route = NavigationItem.FeatureProfile.route
//        ) {
//            FeatureProfile(navigateTo = {
//                navController.navigate(it)
//            },
//                )
//        }


        composable(
            route = NavigationItem.FeatureProfile.route + "/{userId}",
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.StringType
                    defaultValue = "0"
                }
            )
        ) {
            FeatureProfile(
                navigateTo = {
                    navController.navigate(it)
                },
                userId = it.arguments?.getString("userId")
            )
        }
    }
}
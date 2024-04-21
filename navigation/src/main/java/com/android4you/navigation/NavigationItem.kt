package com.android4you.navigation

sealed class NavigationItem(
    val route: String,
    val title: String,
    val navBack: String = "",
) {

    object AppScreen : NavigationItem(
        "app_screen",
        title = "Home",
    )

    object FeatureHome : NavigationItem(
        route = "home_screen",
        title = "Spaces",
    )

    object FeatureProfile : NavigationItem(
        route = "profile_screen",
        title = "Manual Bill Split",
    )


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

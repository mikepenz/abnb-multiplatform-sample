package com.airbnb.sample.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.airbnb.sample.screens.profile.RenderProfile
import com.airbnb.sample.ui.components.TabContent
import com.airbnb.sample.ui.resources.Drawables

internal sealed interface Tabs {
    companion object {
        val anonymous: List<Tab> = listOf(
            Anonymous.Explore,
            Anonymous.Wishlists,
            Anonymous.Trips,
            Anonymous.Inbox,
            Anonymous.Login
        )
    }
    sealed interface Anonymous : Tabs {

        data object Explore : Tabs, Tab {
            @Composable
            override fun Content() {
                TabContent(Screens.Main.Explore)
            }

            override val options: TabOptions
                @Composable get() {
                    val icon = rememberVectorPainter(Icons.Rounded.Search)
                    return remember {
                        TabOptions(
                            index = 0u,
                            title = "Explore",
                            icon = icon
                        )
                    }
                }
        }

        data object Wishlists : Tabs, Tab {
            @Composable
            override fun Content() {
                TabContent(Screens.Main.Wishlists)
            }

            override val options: TabOptions
                @Composable get() {
                    val icon = rememberVectorPainter(Icons.Rounded.FavoriteBorder)

                    return remember {
                        TabOptions(
                            index = 1u,
                            title = "Wishlists",
                            icon = icon
                        )
                    }
                }
        }

        data object Trips : Tabs, Tab {
            @Composable
            override fun Content() {
                TabContent(Screens.Main.Trips)
            }

            override val options: TabOptions
                @Composable get() {
                    val icon = Drawables.AirbnbLogo

                    return remember {
                        TabOptions(
                            index = 2u,
                            title = "Trips",
                            icon = icon
                        )
                    }
                }
        }

        data object Inbox : Tabs, Tab {
            @Composable
            override fun Content() {
                TabContent(Screens.Main.Inbox)
            }

            override val options: TabOptions
                @Composable get() {
                    val icon = Drawables.ChatCentered

                    return remember {
                        TabOptions(
                            index = 3u,
                            title = "Inbox",
                            icon = icon
                        )
                    }
                }
        }

        data object Login : Tabs, Tab {
            @Composable
            override fun Content() {
                TabContent(Screens.Main.Profile)
            }

            override val options: TabOptions
                @Composable get() {
                    val icon = rememberVectorPainter(Icons.Rounded.AccountCircle)

                    return remember {
                        TabOptions(
                            index = 4u,
                            title = "Log in",
                            icon = icon
                        )
                    }
                }
        }
    }
}
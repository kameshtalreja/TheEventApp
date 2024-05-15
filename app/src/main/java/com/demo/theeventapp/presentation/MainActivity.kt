package com.demo.theeventapp.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.theeventapp.R
import com.demo.theeventapp.presentation.compose_components.DrawerContent
import com.demo.theeventapp.data.EventCardItem
import com.demo.theeventapp.presentation.screens.AgendaScreen
import com.demo.theeventapp.presentation.screens.HomeScreen
import com.demo.theeventapp.presentation.screens.OtherScreen
import com.demo.theeventapp.ui.theme.TheEventAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            context = this
            TheEventAppTheme {

                MyApp(context)
            }
        }
    }
}


fun getItems(requireContext: Context)  =  listOf<EventCardItem>(

        EventCardItem(
            drawableImage = R.drawable.agenda,
            backgroundColor = Color(requireContext.resources.getColor(R.color.one))
        ),
        EventCardItem(
            drawableImage = R.drawable.speakers,
            backgroundColor = Color(requireContext.resources.getColor(R.color.two))
        ),
        EventCardItem(
            drawableImage = R.drawable.badge,
            backgroundColor = Color(requireContext.resources.getColor(R.color.three))
        ),
        EventCardItem(
            drawableImage = R.drawable.venue,
            backgroundColor = Color(requireContext.resources.getColor(R.color.one))
        ),
        EventCardItem(
            drawableImage = R.drawable.images,
            backgroundColor = Color(requireContext.resources.getColor(R.color.two))
        ),
        EventCardItem(
            drawableImage = R.drawable.videos,
            backgroundColor = Color(requireContext.resources.getColor(R.color.three))
        ),
        EventCardItem(
            drawableImage = R.drawable.questions,
            backgroundColor = Color(requireContext.resources.getColor(R.color.one))
        ),
        EventCardItem(
            drawableImage = R.drawable.voting,
            backgroundColor = Color(requireContext.resources.getColor(R.color.two))
        ),
        EventCardItem(
            drawableImage = R.drawable.social,
            backgroundColor = Color(requireContext.resources.getColor(R.color.three))
        ),
        EventCardItem(
            drawableImage = R.drawable.survey,
            backgroundColor = Color(requireContext.resources.getColor(R.color.one))
        ),
        EventCardItem(
            drawableImage = R.drawable.cme,
            backgroundColor = Color(requireContext.resources.getColor(R.color.two))
        ),
        EventCardItem(
            drawableImage = R.drawable.more,
            backgroundColor = Color(requireContext.resources.getColor(R.color.three))
        )
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(context: Context) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navBarColor = Color(0xFF195C7F)
    var selectedItemMain by remember { mutableIntStateOf(R.string.menu_home) }
    val navController = rememberNavController()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(selectedItemMain, onItemSelected = { selectedItem ->
                scope.launch { drawerState.close() }
                selectedItemMain = selectedItem
                when (selectedItem) {
                    R.string.menu_home -> navController.navigate("home")
                    R.string.menu_agenda -> navController.navigate("agenda")
                    else -> {
                        navController.navigate("other")
                    }
                }
            })

        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {  },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    Icons.Default.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.White)
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = navBarColor
                        )
                    )
                },
                content = { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") { HomeScreen(items = getItems(requireContext = context)) }
                            composable("agenda") { AgendaScreen() }
                            composable("other") { OtherScreen(title = selectedItemMain) }
                        }
                    }
                }
            )
        }
    )
}


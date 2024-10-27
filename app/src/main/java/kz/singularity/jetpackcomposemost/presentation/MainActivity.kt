package kz.singularity.jetpackcomposemost.presentation

import BottomNavigationBar
import NavHostContainer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltClassWithParams
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltClassWithSeveralParams
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltClassWithoutParams
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltDatabase
import kz.singularity.jetpackcomposemost.presentation.ui.theme.JetpackComposeMostTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Koin examples
//    val classWithoutParams: ClassWithoutParams by inject()
//    val classWithParams: ClassWithParams by inject()
//    val classWithSeveralParams: ClassWithSeveralParams = get()
//    val database: Database by inject()

    //Hilt Examples
//    @Inject lateinit var variableName: VariableTYpe
    @Inject
    lateinit var hiltClassWithParams: HiltClassWithParams

    @Inject
    lateinit var hiltClassWithoutParams: HiltClassWithoutParams

    @Inject
    lateinit var hiltClassWithSeveralParams: HiltClassWithSeveralParams

    //    @Inject
//    lateinit var apiService: ApiService
    @Inject
    lateinit var hiltDatabase: HiltDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hiltClassWithoutParams.execute()
        hiltClassWithParams.execute()
        hiltClassWithSeveralParams.execute()

        Log.e("TAG", hiltDatabase.getUsers().toString())

        setContent {
            JetpackComposeMostTheme {
                val navController = rememberNavController()

                Surface(color = Color.White) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            NavHostContainer(navController = navController, padding = padding)
                        }
                    )
                }
            }
        }
    }
}



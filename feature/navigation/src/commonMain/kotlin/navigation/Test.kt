package navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import common_ui.CommonUI

@Composable
fun HelloTest() {
    val viewModel= viewModel { OrderViewModel() }
    val navController= rememberNavController()
    NavHost(
        navController=navController,
        startDestination = "home",
    ){
        composable(route = "home"){
            CommonUI()

        }
    }

}
class OrderViewModel : ViewModel() {
    init {
        println("Hello From View Model")
    }
}
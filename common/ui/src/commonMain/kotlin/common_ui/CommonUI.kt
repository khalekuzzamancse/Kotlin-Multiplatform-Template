package common_ui

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun CommonUI() {
    val window= calculateWindowSizeClass().widthSizeClass
    when(window){
        WindowWidthSizeClass.Compact->{
            Text("Compact")
        }
        WindowWidthSizeClass.Medium->{
            Text("Medium")
        }
        WindowWidthSizeClass.Expanded->{
            Text("Expanded")
        }
    }

}
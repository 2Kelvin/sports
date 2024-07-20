package com.example.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.sports.ui.SportsApp
import com.example.sports.ui.theme.SportsTheme

/**
 * Activity for Sports app
 */
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SportsTheme {
                Surface {
                    // variable storing the screen size of the current device running this app
                    val windowSize = calculateWindowSizeClass(activity = this)

                    SportsApp(
                        // current device's screen width
                        //  used for adaptive layout change
                        // if the screen width is small -> Compact layout is displayed
                        // if the screen width is medium -> Medium layout is displayed
                        // if the screen width is large -> Expanded layout is displayed
                        windowSize = windowSize.widthSizeClass,
                        onBackPressed = { finish() } // close the app, when the back button is pressed
                    )
                }
            }
        }
    }
}

package com.example.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

/* Compact Screen preview */
@Preview(showBackground = true)
@Composable
fun SportsAppCompactPreview() {
    SportsTheme {
        Surface {
            // using the default small phone screen
            // which uses the Compact layout
            SportsApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}

/* Medium Screen preview */
// widthDp sets the width of the preview screen
@Preview(showBackground = true, widthDp = 700)
@Composable
fun SportsAppMediumPreview() {
    SportsTheme {
        Surface {
            SportsApp(windowSize = WindowWidthSizeClass.Medium)
        }
    }
}

/* Expanded Screen preview */
@Preview(showBackground = true, widthDp = 1000)
@Composable
fun SportsAppExpandedPreview() {
    SportsTheme {
        Surface {
            SportsApp(windowSize = WindowWidthSizeClass.Expanded)
        }
    }
}

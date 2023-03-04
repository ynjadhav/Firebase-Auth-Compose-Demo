package net.mvvmexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import net.mvvmexample.navigation.AppNavHost
import net.mvvmexample.ui.theme.AppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavHost()
            }
        }
    }
}
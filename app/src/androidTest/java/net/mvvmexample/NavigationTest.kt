package net.mvvmexample

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import net.mvvmexample.navigation.ROUTE_LOGIN
import net.mvvmexample.navigation.ROUTE_SIGNUP
import net.mvvmexample.ui.auth.LoginScreen
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val context: Context = InstrumentationRegistry.getInstrumentation().getTargetContext()

    lateinit var navController: TestNavHostController

    @Before
    fun setUpNavHost(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            LoginScreen(navController = navController)
        }
    }

    @Test
    fun verify_IfStartDestinationIsLogin(){
        composeTestRule
            .onNodeWithText(context.resources.getString(R.string.login))
            .assertIsDisplayed()
    }

//    @Test
//    fun performClick_SignUpButton_navigate(){
//
//        composeTestRule
//            .onNodeWithText(context.resources.getString(R.string.dont_have_account))
//            .performClick()
//
//        val route = navController.currentBackStackEntry?.destination?.route
//        println("route "+route)
//        Assert.assertEquals(route, ROUTE_SIGNUP)
//    }
}
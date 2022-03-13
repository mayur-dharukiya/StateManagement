package com.revature.statemanagement

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.revature.statemanagement.ui.theme.StateManagementTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StateManagementTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  //  Greeting("Android")

                   RememberSample()
                   // RememberFragment()


                }
            }
        }
    }
}


@Composable
fun RememberSample() {
    var   clickCount by rememberSaveable { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}

@Composable
fun RememberFragment() {
    var   clickCount by rememberSaveable { mutableStateOf(0) }

    var context= LocalContext.current

    Column {
        Button(onClick = { context.startActivity(Intent(context,BlankFragment::class.java))}) {
            Text(text =  " Go to Fragment")
        }
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateManagementTheme {
        Greeting("Android")
    }
}

package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.myapplication.IU
import com.example.myapplication.ui.theme.MyApplicationTheme

// Definición de variables
val TAG: String = "estado"
val name: String = "Android"


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializo la clase ViewModel
        val miViewModel: MyViewModel = MyViewModel()

        setContent {
            MyApplicationTheme {

                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    IU(miViewModel)

                }
            }
        }
        Log.d(TAG, "Estoy en on Create")
    }

    // Estados de la app
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "He llegado al onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "He llegado al onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "He llegado al onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "He llegado al onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "He llegado al onDestroy")
    }

}
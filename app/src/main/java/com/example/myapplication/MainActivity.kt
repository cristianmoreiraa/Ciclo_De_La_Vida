package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    val TAG = "Estado"
    var name: String = "PoPi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Yellow

                ) {
                    Interfazusuario()
                    Greeting(name)
                }
            }
        }
        Log.d(TAG, "Estoy programando en Android")

        calcular(3, 5) { numero1, numero2 ->
            val suma = numero1 + numero2
            Log.d("Calcular", suma.toString())
        }
        calcular(7, 8) { a, b ->
            val resta = a - b
            Log.d("Calcular", resta.toString())
        }
        sinParametros(5, 6) {
            Log.d("Parametros", "Solo LOG")
        }
    }

    fun calcular(a: Int = 0, b: Int = 0, operation: (a: Int, b: Int) -> Unit) {
        operation(a, b)
    }

    fun sinParametros(a: Int, b: Int, noMuestra: () -> Unit) {
        noMuestra()
    }

    @Composable
    fun Interfazusuario() {
        val imageSize = 5.dp
        val imageModifier = Modifier
            .size(imageSize)
        val image: Painter = painterResource(id = R.drawable.waifus)
        Image(
            painter = image,
            contentDescription = "Copa del Mundo",
            modifier = imageModifier,
            contentScale = ContentScale.Crop // Escala la imagen para llenar la pantalla
        )

        // Contenido encima de la imagen
        Box(

            contentAlignment = Alignment.Center
        ) {
            login()
            texto_descriptivo()
            chat()
        }
    }


    fun login() {
        // texto y botón para logearse
    }

    fun texto_descriptivo() {
        // Texto y botón descriptivo
    }

    fun chat() {
        // Función de chat
    }

    // Resto del código...

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Esto se ejecuta en el start del teléfono")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Estoy en onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Estpy en onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Estoy en onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Estoy en onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Mi nombre es $name!\n\nHola Damián",
        modifier = modifier,
        fontSize = 40.sp,
        color = Color.Red,
        textDecoration = TextDecoration.Underline, // Subraya el texto

    )
    Button(
        onClick = { Log.d("calcular", "Click!!!") },
        modifier = Modifier
            .size(100.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(text = "Click Me")
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Máximo Décimo Meridio, comandante de los ejércitos del Norte, general de las legiones medias, fiel servidor del verdadero emperador, Marco Aurelio, padre de un hijo asesinado, marido de una mujer asesinada y alcanzaré mi venganza, en esta vida o en la próxima")
    }
}

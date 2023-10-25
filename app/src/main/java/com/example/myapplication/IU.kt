package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.MyViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

/**
 * Composable que representa la interfaz principal de la aplicación.
 * Toma un ViewModel como argumento para gestionar la lógica de la aplicación.
 */
@Composable
fun IU(miViewModel: MyViewModel) {

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen en la parte superior de la pantalla
        Image(
            painter = painterResource(R.drawable.balaidos),
            contentDescription = "icono",
            modifier = Modifier
                .size(275.dp)
                .offset(y = 80.dp)
                .offset(x = 70.dp)
        )

        Text( // Línea de texto donde aparece la lista de números aleatorios después de pulsar el botón
            text = "Número Carnet Socio: ${miViewModel.getListaRandom()}", // Llama al método que devuelve la lista de números aleatorios
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .offset(y = 300.dp)
                .offset(x = 30.dp)
        )

        Button( // Botón para generar la lista de números aleatorios
            onClick = { miViewModel.crearRandom() },
            modifier = Modifier
                .offset(y = 330.dp)
                .offset(x = 40.dp)
        ) {// Elementos del botón (imagen y texto)
            Image(
                painter = painterResource(id = R.drawable.escudocelta),
                contentDescription = "Generar números",
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp)
            )
            Text(text = "Click para generar socios")
        }
    }

    // Llama a la función Login y SimonSais para mostrar más contenido en la interfaz
    Login(miViewModel)
    SimonSais(miViewModel)
}

@Composable
fun SimonSais(miViewModel: MyViewModel) {

    Box {
        // Cuadro de suma de rondas
        if (miViewModel.getContador() < 10) {
            Text(
                "Estamos en la Ronda: ${miViewModel.getContador()}",
                modifier = Modifier.offset(y = 400.dp, x = 50.dp),
                fontSize = 24.sp
            )
        } else {
            Text(
                "Estamos en la Ronda: ${miViewModel.getContador()}",
                modifier = Modifier.offset(y = 400.dp, x = 50.dp),
                fontSize = 24.sp
            )
        }

        // Botones de colores
        Button( // Botón azul
            onClick = {},
            modifier = Modifier
                .offset(y = 450.dp)
                .offset(x = 100.dp)
                .size(75.dp) // Aumenta el tamaño del botón azul
                .background(color = Color.Blue)
        ) {Text(
            text = "Azul",
            style = TextStyle(fontSize = 10.sp) // Ajusta el tamaño de la fuente a 14.sp o el valor que desees
        )
        }

        Button( // Botón verde
            onClick = {},
            modifier = Modifier
                .offset(y = 450.dp)
                .offset(x = 200.dp)
                .size(75.dp) // Aumenta el tamaño del botón verde
                .background(color = Color.Green)
        ) {
            Text(
                text = "Verde",
                style = TextStyle(fontSize = 10.sp) // Ajusta el tamaño de la fuente a 14.sp o el valor que desees
            )
        }

        Button( // Botón rojo
            onClick = {},
            modifier = Modifier
                .offset(y = 530.dp)
                .offset(x = 100.dp)
                .size(75.dp) // Aumenta el tamaño del botón rojo
                .background(color = Color.Red)
        ) {Text(
            text = "Rojo",
            style = TextStyle(fontSize = 10.sp) // Ajusta el tamaño de la fuente a 14.sp o el valor que desees
        )
        }

        Button( // Botón amarillo
            onClick = {},
            modifier = Modifier
                .offset(y = 530.dp)
                .offset(x = 200.dp)
                .size(75.dp) // Aumenta el tamaño del botón amarillo
                .background(color = Color.Yellow)
        ) {Text(
            text = "Amarillo",
            style = TextStyle(fontSize = 10.sp) // Ajusta el tamaño de la fuente a 14.sp o el valor que desees
        )
        }

        Button( // Botón PLAY
            onClick = { miViewModel.contador() },
            modifier = Modifier
                .size(100.dp, 40.dp)
                .offset(y = 610.dp)
                .offset(x = 200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.escudocelta),
                contentDescription = "Juguemos",
                modifier = Modifier
                    .size(100.dp,200.dp)
            )
        }

        // Llama a la función startReset para mostrar el botón de inicio o reinicio
        startReset()
    }
}

@Composable
fun startReset() {
    var isStart by remember { mutableStateOf(true) }

    Button(
        onClick = {
            isStart = !isStart
        },
        modifier = Modifier
            .size(80.dp, 45.dp)
            .offset(y = 610.dp)
            .offset(x = 70.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = if (isStart) "START" else "RESET", // Cambia el texto del botón
            style = TextStyle(fontSize = 10.sp),

        )
    }
}

/**
 * Función que muestra el contador de clicks y una caja de texto para escribir.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {

    Column {
        // Texto que simula un botón (Clicks) y cuenta cuántas veces se pulsa
            Text( // Línea de texto donde aparece la lista de números aleatorios después de pulsar el botón
                text = "Aficionados en Balaidos: ${miViewModel.getContador()}", // Llama al método que devuelve la lista de números aleatorios
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .offset(y = 10.dp)
                    .offset(x = 80.dp)
            )



        // Caja de texto para escribir
        OutlinedTextField(
            value = miViewModel.getString(),
            onValueChange = {
                miViewModel.name.value = it
            },
            label = { Text(text = "Escribe: ") }
        )

        // Condición para mostrar el contenido de la caja solo si se escriben más de 3 caracteres
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.getString()}",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        IU(miViewModel = MyViewModel())
    }
}

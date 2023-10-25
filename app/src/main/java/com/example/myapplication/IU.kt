package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
 * miViewModel es una instancia de MyViewModel, el cual (miViewModel) se pasará como argumento cuando
 * llamemos a la función IU.
 */
@Composable
fun IU(miViewModel: MyViewModel) {

    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.balaidos),
            contentDescription = "icono",
            modifier = Modifier
                .size(210.dp)
                .offset(y = 120.dp)
                .offset(x = 70.dp)

        )
        Text( //Línea de texto donde aparece la lista de numero aleatorios después de pulsar el botón

            text = "Numeros: ${miViewModel.getListaRandom()}",// Llama al método que me devuelve la lista de números aleatorios
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .offset(y = 300.dp)
                .offset(x = 30.dp)


        )
        Button( //Botón para generar la lista de números aleatorios
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
            Text(text = "Click para generar números")
        }

    }
    Login(miViewModel)
    juegoSimon(miViewModel)

}

@Composable
fun juegoSimon(miViewModel: MyViewModel) {

    Box{
        // Cuadro de suma de rondas
        if(miViewModel.getContador()<10){
            Text("Ronda: ${miViewModel.getContador()}",
                modifier = Modifier.offset(y=400.dp, x= 250.dp))
        }else{
            Text("Ronda: ${miViewModel.getContador()}",
                modifier = Modifier.offset(y=400.dp, x= 250.dp), fontSize = 24.sp)
        }


        Button( //Botón azul
            onClick = {},
            modifier = Modifier
                .offset(y = 470.dp)
                .offset(x = 100.dp)
                .size(40.dp)
                .background(color = Color.Blue)


        ){

        }

        Button( //Botón verde
            onClick = {},
            modifier = Modifier
                .offset(y = 470.dp)
                .offset(x = 200.dp)
                .size(40.dp)
                .background(color = Color.Green)



        ){

        }
        Button( //Botón rojo
            onClick = {},
            modifier = Modifier
                .offset(y = 530.dp)
                .offset(x = 100.dp)
                .size(40.dp)
                .background(color = Color.Red)


        ){

        }

        Button( //Botón amarillo
            onClick = {},
            modifier = Modifier
                .offset(y = 530.dp)
                .offset(x = 200.dp)
                .size(40.dp)
                .background(color = Color.Yellow)



        ){

        }



        Button( //Botón PLAY
            onClick = {miViewModel.contador()},
            modifier = Modifier
                .size(80.dp, 40.dp)
                .offset(y = 610.dp)
                .offset(x = 200.dp)




        ){
            Image(
                painter = painterResource(id = R.drawable.escudocelta),
                contentDescription = "Play",
                modifier = Modifier
                    .size(100.dp)

            )

        }
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
            style = TextStyle (fontSize = 10.sp)
        )
    }

}


/**
 * Función del contador de clicks y de escribir texto en la caja
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {

    Column {

        // Texto que simula un botón (Clicks) y cuenta cuantas veces lo pulsas
        TextButton(onClick = { miViewModel.contador() }) {
            Text("CLICKS: ${miViewModel.getContador()}")
        }

        // Caja de texto para escribir
        OutlinedTextField(
            value = miViewModel.getString(),
            onValueChange = {
                miViewModel.name.value = it
            },
            label = { Text(text = "Escribe:") }
        )

        // Condición para que solo me muestre el contenido de la caja si escribo más de 3 caracteres
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.getString()}",
                fontSize = 20.sp
            )
        }

    }
}

/* ESTO NO LO USO
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // var msj_saludo = stringResource(id = R.string.saludo)
    // var name = remember {mutableStateOf("")}

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.naturaleza),
                contentDescription = "icono",
                modifier = Modifier
                    .size(200.dp)
            )
        }
        Column {
            Text(
                text = "Hola $name",
                fontSize = 50.sp,
                color = Color.Blue,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.saludo),
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = modifier

            )

            Button(onClick = { Log.d("Calcular", "Click!!!") }) {
                Text(text = "Click me!", color = Color.DarkGray)
            }
        }

    }

}
*/

/**
 * Vista previa de la app
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        IU(miViewModel = MyViewModel())
    }
}

/*
//ESTO NO LO USAMOS, es un ejemplo
@Composable
fun InterfazUsuario() {
    login()
    texto_descriptivo("Hola texto")
    chat()
}

@Composable
fun chat() {
    TODO("Not yet implemented")
}

@Composable
fun texto_descriptivo(texto: String) {
    Text(text = texto)
}

@Composable
fun login() {
    texto_descriptivo(texto = "Fallo de login")
}

*/
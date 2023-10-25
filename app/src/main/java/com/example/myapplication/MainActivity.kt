package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.laprimera.IU
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


    /**
     * Esto iría encima de: Log.d(TAG, "Estoy en on Create")

    calcular()//No pongo valores dentro porque ya se los di por defecto al crear la funcion
    //Tambien puedes cambiar el orden de los parametros


    calcular2(aa = 3, bb = 5, fun(numero1: Int, numero2: Int) {
    val suma = numero1 + numero2
    Log.d("calcular", suma.toString())
    })

    calcular2(4, 1, fun(x, y) {
    val resta = x - y
    Log.d("calcular", resta.toString())
    })
    calcularVacio(4, 1, fun() {
    Log.d("calcular", "Yo no hago nada, solo Log")
    })
    calcularVacio {//puedes no escribir el ultimo parametro, es decir, la funcion. Solo puedo hacer esto
    //con el ultimo parametro
    //tambien quitas los dos primeros porque les doy los pametros por defecto
    //tambien se puede prescindir de los parentesis
    Log.d("calcular", "Yo no hago nada, solo Log")
    }

    }

    METODOS CALCULAR
    fun calcular(
    a: Int = 1,
    b: Int = 1
    ) {//les doy valores por defecto, aunque en la "main" ponga otro num, usará estos
    val operacion = a + b
    Log.d("calcular", operacion.toString())
    }

    //operacion es una funcion que recibe dos parametros (x,y) y no devuelve nada
    fun calcular2(aa: Int, bb: Int, operacion: (x: Int, y: Int) -> Unit) {
    operacion(
    aa,
    bb
    )  //en la funcion operacion voy a usar a y b, que representa x e y en la funcion operacion
    }

    fun calcularVacio(a: Int = 0, b: Int = 0, operacion: () -> Unit) {
    operacion()
    }
     **/



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
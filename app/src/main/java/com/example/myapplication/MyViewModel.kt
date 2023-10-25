package com.example.myapplication

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


/**
 * La clase MyViewModel hereda de ViewModel (es una clase que viene predeterminada)
 * MyViewModel() --> Los () implican un constructor explícito, es decir, que así
 * puedo inicializar propiedades al crearcreación de la instancia
 */
class MyViewModel() : ViewModel() {

    private val TAG_LOG: String = "mensaje ViewModel"

    /**
     * Variable _numbers que es observable, y la inicializamos con el valor 0.
     * Se usa mutableStateOf porque la vamos a modificar y queremos que se actualice en la interfaz.
     */
    var _numbers = mutableStateOf(0)

    // Crea una lista mutable de numero aleatorios
    val listaNumRandom = mutableStateListOf<Int>()


    /**
     * Dos maneras diferentes de definir un estado:
     *
     * var counter by remember { mutableStateOf(0) }
     * var name = remember { mutableStateOf("") } --> Si ponemos "=" hay que usar value
     */
    var counter = mutableStateOf(0)

    var name =
        mutableStateOf("") // Lo mismo, pero al poner comillas indico que el valor inicial será un String.


    /**
     * Es otra forma de hacer una instancia de la clase, pero así no proporcionamos ningún valor al crearla.
     * Usamos el bloque init{} para inicializar las propiedades que queramos.
     * Esto se va a ejecutar cuando instancie la clase. Así sabemos cuando arranca el ViewModel.
     */
    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }


    /**
     * Función que crea y almacena numeros aleatorios en una lista
     */
    fun crearRandom() {

        /*
         * Genera un numero aleatorio ente 0 y 3 (incluidos) y lo asigna a la variable _numbers.value
         */
        _numbers.value = (0..3).random()//el value es por el mutableStateOf

        /*
         * Añade el numero aleatorio a la listaNumRandom
         */
        listaNumRandom.add(_numbers.value)

        Log.d(TAG_LOG, "Añado el numero: ${_numbers.value}")

        /**
         * For in que recorre listaNumRandom y va imprimiendo cada número de ella
         */
        for (numero in listaNumRandom) {
            Log.d(TAG_LOG, " Lista de números aleatorios: $numero")
        }

        // _numbers.value = (0..10).random()
        //Log.d(TAG_LOG, "creamos random ${_numbers.value}")

    }


    /**
     * Devuelve el número aleatorio
     */
    fun getNumero(): Int {
        return _numbers.value
    }

    /**
     * Devuelve la listaNumRandom
     */
    fun getListaRandom(): List<Int> {
        return listaNumRandom.toList()
    }

    /**
     * Función de contador que aumenta en 1 el valor de la variable counter cada vez que se llama
     */
    fun contador() {
        counter.value++
    }

    /**
     * Función que devuelve el valor de counter
     */
    fun getContador(): Int {
        return counter.value
    }

    /**
     * Función que devuelve el valor de name
     */
    fun getString(): String {
        return name.value
    }


}

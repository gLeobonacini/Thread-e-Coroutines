package com.kotlin.aula34_threadsecoroutines

import kotlinx.coroutines.delay

class Repository {
    suspend fun getFilmes():String{
        delay(3000)
        return "Resultados"
    }
}
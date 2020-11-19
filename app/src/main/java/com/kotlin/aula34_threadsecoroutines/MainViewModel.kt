package com.kotlin.aula34_threadsecoroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository): ViewModel() {
    val res = MutableLiveData<String>()

    fun getFilmeRepository(){
        try{
            viewModelScope.launch {
                res.value = repository.getFilmes()
            }
        }catch (e: Exception){
            Log.e("MainViewModel",e.toString())
        }
    }

}
package com.thomaskuenneth3

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var number : MutableState<Int> = mutableStateOf(0)
    var name : MutableState<String> = mutableStateOf("nothing")

    fun clicked(newName : String)
    {
        name.value = newName
    }

    fun inc()
    {
        number.value ++
    }
}
package com.ferchu.palabrasiguales.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _isEqual = MutableLiveData<Boolean>()
    val isEqual: LiveData<Boolean> get() = _isEqual

    fun compare(firstText: String, secondText: String) {
        _isEqual.value = firstText == secondText
    }
}
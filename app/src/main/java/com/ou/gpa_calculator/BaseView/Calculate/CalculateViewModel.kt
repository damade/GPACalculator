package com.ou.gpa_calculator.BaseView.Calculate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ou.gpa_calculator.LocalData.DatabaseHelper
import com.ou.gpa_calculator.LocalData.entity.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class CalculateViewModel(private val dbHelper: DatabaseHelper) : ViewModel() {

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default


    fun saveResults(result: Result) {
        viewModelScope.launch {
            try {
                 dbHelper.insert(result)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}
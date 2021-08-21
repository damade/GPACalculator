package com.ou.gpa_calculator.BaseView.Home

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

class HomeViewModel( private val dbHelper: DatabaseHelper) : ViewModel() {

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

    lateinit var results : Flow<List<Result>>

    init {
        fetchResults()
    }

    private fun fetchResults() {
        viewModelScope.launch {
            try {
                results = dbHelper.
                                getResults()
                                .flowOn(defaultDispatcher)

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
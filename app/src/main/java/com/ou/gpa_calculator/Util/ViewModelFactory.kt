package com.ou.gpa_calculator.Util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ou.gpa_calculator.BaseView.Calculate.CalculateFragment
import com.ou.gpa_calculator.BaseView.Calculate.CalculateViewModel
import com.ou.gpa_calculator.BaseView.Home.HomeViewModel
import com.ou.gpa_calculator.LocalData.DatabaseHelper

class ViewModelFactory (private val dbHelper: DatabaseHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(dbHelper) as T
        }
        if (modelClass.isAssignableFrom(CalculateViewModel::class.java)) {
            return CalculateViewModel(dbHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}
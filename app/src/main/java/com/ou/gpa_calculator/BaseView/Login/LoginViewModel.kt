package com.ou.gpa_calculator.BaseView.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ou.gpa_calculator.LocalData.DatabaseHelper
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.LocalData.entity.User
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import java.util.*

class LoginViewModel (private val dbHelper: DatabaseHelper) : ViewModel() {

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

   private val userData : MutableLiveData<User> = MutableLiveData()

    val user : LiveData<User> = userData

    fun queryIfUserExist(userIdG: String, passwordG: String, userTypeG: String) {

        try {
           val userDb =  dbHelper.getUserDetails(userIdG, passwordG, userTypeG)
            userData.postValue(userDb)
            Timber.tag("Inside Life").d(userData.toString())
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
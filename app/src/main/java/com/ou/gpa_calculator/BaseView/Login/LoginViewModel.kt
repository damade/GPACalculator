package com.ou.gpa_calculator.BaseView.Login

import androidx.lifecycle.*
import com.ou.gpa_calculator.LocalData.DatabaseHelper
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.LocalData.entity.User
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import java.util.*


class LoginViewModel ( private val dbHelper: DatabaseHelper) : ViewModel(){

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

    var studentQueryResults : MutableLiveData<User> = MutableLiveData()

    var staffQueryResults : MutableLiveData<User> = MutableLiveData()

    var savedUser: MutableLiveData<Long> = MutableLiveData()


    fun saveStudentUser(user: User) {

        viewModelScope.launch(Dispatchers.IO){
            try {
                val isSaved = dbHelper.saveUserDetails(user)
                Timber.tag("I got here").d(isSaved.toString())
                savedUser.postValue(isSaved)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun queryIfStudentExist(userIdG: String, passwordG: String, userTypeG: String) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                val result = dbHelper
                    .verifyStudentDetails(userIdG, passwordG, userTypeG)
                studentQueryResults.postValue(result)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

     fun queryIfStaffExist(fullNameG: String, passwordG: String, userTypeG: String){
         viewModelScope.launch(Dispatchers.IO){
             try {
                 val result = dbHelper
                     .verifyStaffDetails(fullNameG, passwordG, userTypeG)
                staffQueryResults.postValue(result)
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
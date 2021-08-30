package com.ou.gpa_calculator.BaseView.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ou.gpa_calculator.DataBase.UserDataRepository
import com.ou.gpa_calculator.DataBase.UsersDataClass
import com.ou.gpa_calculator.LocalData.DatabaseHelper
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.LocalData.entity.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import java.util.*
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(private val userDataRepository: UserDataRepository):ViewModel() {



    fun insertNewUserViewModel(usersDataClass: UsersDataClass) = viewModelScope.launch {
        userDataRepository.insertUserDataDao(usersDataClass)
    }

    fun updateUserViewModel(usersDataClass: UsersDataClass) = viewModelScope.launch {
        userDataRepository.updateUserDataDao(usersDataClass)
    }

    private val allUser: LiveData<List<UsersDataClass>> = userDataRepository.getAllUsers()

    fun getAllUsers(): LiveData<List<UsersDataClass>>{
        return allUser
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
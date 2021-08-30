package com.ou.gpa_calculator.LocalData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.LocalData.entity.User
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    suspend fun getResults(): Flow<List<Result>>

    suspend fun insert(result: Result)

    suspend fun deleteALlResults()

    suspend fun insertAllUsers(users: List<User>)

    suspend fun saveUserDetails(user: User)

    fun getUserDetails(userIdG: String, passwordG: String, userTypeG: String): User

    suspend fun getAllUsers(): LiveData<List<User>>

}
package com.ou.gpa_calculator.DataBase

import androidx.lifecycle.LiveData


interface UserDaoHelper {

    suspend fun insertUserDataDao(usersDataClass: UsersDataClass)

    suspend fun updateUserDataDao(usersDataClass: UsersDataClass)

    suspend fun deleteAllUsers()

    fun getAllUsers() : LiveData<List<UsersDataClass>>
}
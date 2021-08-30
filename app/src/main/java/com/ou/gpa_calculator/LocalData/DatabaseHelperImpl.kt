package com.ou.gpa_calculator.LocalData

import androidx.lifecycle.LiveData
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.LocalData.entity.User
import kotlinx.coroutines.flow.Flow

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getResults(): Flow<List<Result>> = appDatabase.resultDao().getAll()

    override suspend fun insert(result: Result) = appDatabase.resultDao().insert(result)

    override suspend fun deleteALlResults() = appDatabase.resultDao().deletedAllResults()

        //For Users
    override suspend fun insertAllUsers(users: List<User>)  = appDatabase.userDao().insertAllUsers(users)

    override suspend fun saveUserDetails(user: User) = appDatabase.userDao().insert(user)

    override fun getUserDetails(userIdG: String, passwordG: String, userTypeG: String) = appDatabase
        .userDao().isLoginCorrect(userIdG, passwordG, userTypeG)

    override suspend fun getAllUsers(): LiveData<List<User>> = appDatabase.userDao().getAllUsers()


}
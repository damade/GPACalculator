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

    override suspend fun saveUserDetails(user: User): Long = appDatabase.userDao().insertUser(user)

    override suspend  fun verifyStudentDetails(userIdG: String, passwordG: String, userTypeG: String): User
    = appDatabase.userDao().isStudentLoginCorrect(userIdG, passwordG, userTypeG)

    override suspend fun verifyStaffDetails(fullNameG: String, passwordG: String, userTypeG: String): User
    = appDatabase.userDao().isStaffLoginCorrect(fullNameG, passwordG, userTypeG)

    override suspend fun getAllUsers(): LiveData<List<User>> = appDatabase.userDao().getAllUsers()


}
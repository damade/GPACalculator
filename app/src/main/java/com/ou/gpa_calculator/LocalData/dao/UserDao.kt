package com.ou.gpa_calculator.LocalData.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.ou.gpa_calculator.LocalData.entity.User
import com.ou.gpa_calculator.Util.TypeConverter
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @TypeConverters(TypeConverter::class)
    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>


    @Insert
    suspend fun insert(user: User)

    @Insert
    fun insertAllUsers(users: List<User>)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user")
    suspend fun deletedAllUsers()

//    @Query("SELECT *  FROM user WHERE userId like :userIdG AND password like :passwordG AND userType like :userTypeG")
//    fun isLoginCorrect(userIdG: String, passwordG: String, userTypeG: String): User

}
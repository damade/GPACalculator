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


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Long

    @Insert
    fun insertAllUsers(users: List<User>)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user")
    suspend fun deletedAllUsers()

   @Query("SELECT *  FROM user WHERE matricNo like :userIdG AND password like :passwordG AND userType like :userTypeG")
   fun isStudentLoginCorrect(userIdG: String, passwordG: String, userTypeG: String): User

    @Query("SELECT *  FROM user WHERE fullName like :fullNameG AND password like :passwordG AND userType like :userTypeG")
    fun isStaffLoginCorrect(fullNameG: String, passwordG: String, userTypeG: String): User

}
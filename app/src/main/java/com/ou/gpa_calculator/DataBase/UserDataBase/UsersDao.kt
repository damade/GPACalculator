package ccom.ou.gpa_calculator.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ou.gpa_calculator.DataBase.UsersDataClass

@Dao
abstract class UsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertUserDataDao(usersDataClass: UsersDataClass)

    @Update
    abstract suspend fun updateUserDataDao(usersDataClass: UsersDataClass)

    @Query("SELECT * FROM user_data")
    abstract fun getAllUsers() : LiveData<List<UsersDataClass>>

    @Query("DELETE FROM user_data")
    abstract suspend fun deleteAllUsers()
}
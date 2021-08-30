package com.ou.gpa_calculator.DataBase




import androidx.lifecycle.LiveData

import javax.inject.Inject

/*class UserDataRepository @Inject constructor (private val usersDao: UsersDao) : UserDaoHelper {
    override suspend fun insertUserDataDao(usersDataClass: UsersDataClass) = usersDao.insertUserDataDao(usersDataClass)

    override suspend fun updateUserDataDao(usersDataClass: UsersDataClass) = usersDao.updateUserDataDao(usersDataClass)
    override suspend fun deleteAllUsers() = usersDao.deleteAllUsers()

    override fun getAllUsers(): LiveData<List<UsersDataClass>> = usersDao.getAllUsers()


//    val allUsers: LiveData<List<UsersDataClass>> = usersDao.getAllUsers()
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    fun insertUserRepo(usersDataClass: UsersDataClass){
//        usersDao.insertUserDataDao(usersDataClass)
//    }
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    fun updateUserRepo(usersDataClass: UsersDataClass){
//        usersDao.updateUserDataDao(usersDataClass)
//    }


}*/

class UserDataRepository @Inject constructor (private val sharedRoomDatabase: SharedRoomDatabase) : UserDaoHelper {
    override suspend fun insertUserDataDao(usersDataClass: UsersDataClass) = sharedRoomDatabase.usersDao().insertUserDataDao(usersDataClass)

    override suspend fun updateUserDataDao(usersDataClass: UsersDataClass) = sharedRoomDatabase.usersDao().updateUserDataDao(usersDataClass)
    override suspend fun deleteAllUsers() = sharedRoomDatabase.usersDao().deleteAllUsers()

    override fun getAllUsers(): LiveData<List<UsersDataClass>> = sharedRoomDatabase.usersDao().getAllUsers()


//    val allUsers: LiveData<List<UsersDataClass>> = usersDao.getAllUsers()
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    fun insertUserRepo(usersDataClass: UsersDataClass){
//        usersDao.insertUserDataDao(usersDataClass)
//    }
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    fun updateUserRepo(usersDataClass: UsersDataClass){
//        usersDao.updateUserDataDao(usersDataClass)
//    }


}
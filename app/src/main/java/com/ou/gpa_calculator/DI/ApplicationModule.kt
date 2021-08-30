package com.ou.gpa_calculator.DI

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ccom.ou.gpa_calculator.DataBase.UsersDao
import com.ou.gpa_calculator.DataBase.SharedRoomDatabase
import com.ou.gpa_calculator.DataBase.UsersDataClass
import com.ou.gpa_calculator.LocalData.entity.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Singleton

const val PREFERENCE_NAME = "all_data_pref"

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    private const val USER_DATA_BASE_NAME = "tables"
    private lateinit var database: SharedRoomDatabase

    @Singleton
    @Provides
    fun providesSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun providesRoomDatabase(@ApplicationContext context: Context): SharedRoomDatabase{
        database = Room.databaseBuilder(
            context, SharedRoomDatabase::class.java, USER_DATA_BASE_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    GlobalScope.launch {
                        populateDB(database.usersDao())
                       //database.usersDao().insertUserDataDao(UsersDataClass("okanrende oladotun ", "oladotun@gmail.com", "lagos", "081223070", "1234", "30000000"))



                    }
                }
            }

            )
            .build()

        return database
    }



    @Singleton
    @Provides
    suspend fun populateDB(usersDao: UsersDao){
        usersDao.insertUserDataDao(
            UsersDataClass("u/17/cs/0123", "okafor"))
        usersDao.insertUserDataDao(UsersDataClass("u/17/cs/0205", "williams"))
        usersDao.insertUserDataDao(UsersDataClass("u/17/cs/0011", "olashina"))
        usersDao.insertUserDataDao(UsersDataClass("u/17/cs/0187", "adewale"))
        usersDao.insertUserDataDao(UsersDataClass("u/17/cs/0056", "adisa"))
        usersDao.insertUserDataDao(UsersDataClass("u/17/cs/0131", "stone"))
        usersDao.insertUserDataDao(UsersDataClass("u/17/cs/0067", "martins"))
        usersDao.insertUserDataDao(UsersDataClass("u/17/cs/0126", "steven"))
        usersDao.insertUserDataDao(UsersDataClass("Oluwatobi", "ayilara"))
        usersDao.insertUserDataDao(UsersDataClass("PrinceWill", "akpojotor"))



    }


    @Singleton
    @Provides
    fun providesUserDaoHelper(sharedRoomDatabase: SharedRoomDatabase): UsersDao = sharedRoomDatabase.usersDao()

}
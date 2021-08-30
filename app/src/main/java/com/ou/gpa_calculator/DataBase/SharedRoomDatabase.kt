package com.ou.gpa_calculator.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ccom.ou.gpa_calculator.DataBase.UsersDao

@Database(entities = [UsersDataClass::class],
    version = 1, exportSchema = false)
abstract class SharedRoomDatabase():RoomDatabase() {

    abstract fun usersDao(): UsersDao


//    companion object{
//        @Volatile
//        private var INSTANCE: SharedRoomDatabase?= null
//
//        fun getDatabase(
//            context: Context,
//            scope:CoroutineScope
//        ): SharedRoomDatabase{
//            return INSTANCE?: synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    SharedRoomDatabase::class.java,
//                    "user_data"
//                )
//                    .fallbackToDestructiveMigration()
//                    .addCallback(UserRoomDatabaseCallBack())
//                    .build()
//
//                INSTANCE = instance
//
//                instance
//
//            }
//        }
//
//        private class UserRoomDatabaseCallBack :RoomDatabase.Callback(){
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
////                INSTANCE?.let {
////                    database ->
////                    scope.launch(Dispatchers.IO){
////
////                    }
////                }
//            }
//            }
//    }
}
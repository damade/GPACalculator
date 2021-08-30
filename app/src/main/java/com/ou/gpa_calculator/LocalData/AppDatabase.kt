package com.ou.gpa_calculator.LocalData

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ou.gpa_calculator.LocalData.dao.ResultDao
import com.ou.gpa_calculator.LocalData.dao.UserDao
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.LocalData.entity.User
import com.ou.gpa_calculator.Util.TypeConverter

@Database(entities = arrayOf(Result::class, User::class), version = 1)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun resultDao(): ResultDao

    abstract fun userDao(): UserDao

}
package com.ou.gpa_calculator.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UsersDataClass(
    @ColumnInfo(name = "userId") val userId: String,
    @ColumnInfo(name = "password") val password: String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
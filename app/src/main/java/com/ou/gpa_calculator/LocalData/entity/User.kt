package com.ou.gpa_calculator.LocalData.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class User(@ColumnInfo(name = "userId") var userId: String,
                @ColumnInfo(name = "password") var password: String?,
                @ColumnInfo(name = "userType") var userType: String?,
                @ColumnInfo(name = "date") var date: Date?
){
    @PrimaryKey(autoGenerate = true) var id: Int? = null

}
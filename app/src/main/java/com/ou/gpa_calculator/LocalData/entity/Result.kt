package com.ou.gpa_calculator.LocalData.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Result(@ColumnInfo(name = "cgpa") var cgpa: Double,
                  @ColumnInfo(name = "semester") var semester: Int?,
                  @ColumnInfo(name = "date") var date: Date?
){
    @PrimaryKey(autoGenerate = true) var id: Int? = null

}
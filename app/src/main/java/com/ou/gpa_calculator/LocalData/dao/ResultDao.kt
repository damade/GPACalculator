package com.ou.gpa_calculator.LocalData.dao

import androidx.room.*
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.Util.TypeConverter
import kotlinx.coroutines.flow.Flow


@Dao
interface ResultDao {

    @TypeConverters(TypeConverter::class)
    @Query("SELECT * FROM result ORDER BY date DESC")
    fun getAll(): Flow<List<Result>>

    @Insert
    suspend fun insert(result: Result)

    @Delete
    suspend fun delete(result: Result)

    @Query("DELETE FROM result")
    suspend fun deletedAllResults()

}
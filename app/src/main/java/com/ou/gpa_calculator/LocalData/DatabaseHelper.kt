package com.ou.gpa_calculator.LocalData

import com.ou.gpa_calculator.LocalData.entity.Result
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    suspend fun getResults(): Flow<List<Result>>

    suspend fun insert(result: Result)

    suspend fun deleteALlResults()

}
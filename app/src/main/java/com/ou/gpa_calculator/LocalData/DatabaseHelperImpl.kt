package com.ou.gpa_calculator.LocalData

import com.ou.gpa_calculator.LocalData.entity.Result
import kotlinx.coroutines.flow.Flow

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getResults(): Flow<List<Result>> = appDatabase.resultDao().getAll()

    override suspend fun insert(result: Result) = appDatabase.resultDao().insert(result)

    override suspend fun deleteALlResults() = appDatabase.resultDao().deletedAllResults()

}
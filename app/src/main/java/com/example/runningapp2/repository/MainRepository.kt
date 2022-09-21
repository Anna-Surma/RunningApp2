package com.example.runningapp2.repository

import com.example.runningapp2.database.Run
import com.example.runningapp2.database.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val runDao: RunDAO): MainRepositoryImpl {

    override suspend fun insertRun(run: Run) = runDao.insertRun(run)

    override suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    override fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByDate()

    override fun getAllRunsSortedByDistance() = runDao.getAllRunsSortedByDistance()

    override fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()

    override fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgSpeed()

    override fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()

    override fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()

    override fun getTotalDistance() = runDao.getTotalDistance()

    override fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

    override fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()
}
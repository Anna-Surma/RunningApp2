package com.example.runningapp2.viewModels

import androidx.lifecycle.ViewModel
import com.example.runningapp2.repository.MainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val mainRepository: MainRepositoryImpl
) : ViewModel() {
}
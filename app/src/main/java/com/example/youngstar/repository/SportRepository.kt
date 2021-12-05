package com.example.youngstar.repository

import com.example.youngstar.retrofit.ApiService
import kotlinx.coroutines.flow.flow

class SportRepository(private val apiService: ApiService) {

    suspend fun getAllSportTowers() = flow { emit(apiService.getAllSportTowers()) }
}
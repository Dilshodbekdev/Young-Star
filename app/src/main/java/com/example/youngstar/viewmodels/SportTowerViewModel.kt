package com.example.youngstar.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youngstar.repository.SportRepository
import com.example.youngstar.utils.DataResource
import com.example.youngstar.utils.NetworkHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SportTowerViewModel(
    private val sportRepository: SportRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    fun fetchSportTowers(): StateFlow<DataResource> {
        val stateFlow = MutableStateFlow<DataResource>(DataResource.Loading)

        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                sportRepository.getAllSportTowers()
                    .catch {
                        stateFlow.emit(DataResource.Error(it.message ?: ""))
                    }.collect { it ->
                        if (it.isSuccessful) {
                            stateFlow.emit(DataResource.Success(it.body()?.data))
                        } else {
                            when {
                                it.code() in 400..499 -> {
                                    stateFlow.emit(DataResource.Error("Client error"))
                                }
                                it.code() in 500..599 -> {
                                    stateFlow.emit(DataResource.Error("Server error"))
                                }
                                else -> {
                                    stateFlow.emit(DataResource.Error("Other error"))
                                }
                            }
                        }
                    }
            } else {
                stateFlow.emit(DataResource.Error("No internet connection"))
            }
        }

        return stateFlow
    }
}
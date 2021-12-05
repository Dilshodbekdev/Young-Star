package com.example.youngstar.utils

import com.example.youngstar.models.sport_tower.Data
import com.example.youngstar.models.sport_tower.SportTower

sealed class DataResource {

    object Loading : DataResource()

    data class Success(val list: List<Data>?) : DataResource()

    data class Error(val message: String) : DataResource()
}
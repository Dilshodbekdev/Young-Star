package com.example.youngstar.retrofit


import com.example.youngstar.models.sport_tower.Data
import com.example.youngstar.models.sport_tower.SportTower
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("admin/tower/get-all")
    suspend fun getAllSportTowers(): Response<SportTower>

/*    @GET("api/authors/")
    suspend fun getAuthorsList(@Query("format") format: String = "json"): Response<List<AuthorData>>*/
}
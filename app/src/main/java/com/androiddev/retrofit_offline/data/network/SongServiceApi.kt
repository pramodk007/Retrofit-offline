package com.androiddev.retrofit_offline.data.network

import com.androiddev.retrofit_offline.data.entities.SearchResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SongServiceApi {
    @GET("search")
    suspend fun getSearchResults(@Query("term") searchTerm: CharSequence): Response<SearchResultModel>

    @GET("search?term=jack+johnson")
    suspend fun getJack(): Response<SearchResultModel>
}
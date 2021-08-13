package com.androiddev.retrofit_offline.data.network

import javax.inject.Inject

class SongServiceImplementation @Inject constructor(
    private val songServiceApi: SongServiceApi
):BaseDataSource(){

    suspend fun getSong(search:String) = getResult {
        songServiceApi.getSearchResults(search)
    }
}
package com.androiddev.retrofit_offline.data.repository

import com.androiddev.retrofit_offline.data.local.SongDataBase
import com.androiddev.retrofit_offline.data.network.SongServiceImplementation
import com.androiddev.retrofit_offline.utils.performGetOperation
import javax.inject.Inject

class SongRepository @Inject constructor(
    private val remoteDataSource: SongServiceImplementation,
    private val localDataSource: SongDataBase

){
    private val songDao = localDataSource.songDao()

    fun getSongs(search: String) = performGetOperation(
        databaseQuery = { songDao.getAllSongs() },
        networkCall = { remoteDataSource.getSong(search) },
        saveCallResult = {
            songDao.deleteAllSong()
            songDao.insertAll(it.resultModels) }
    )
}
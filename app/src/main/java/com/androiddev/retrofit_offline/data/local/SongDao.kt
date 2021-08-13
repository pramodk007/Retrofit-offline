package com.androiddev.retrofit_offline.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androiddev.retrofit_offline.data.entities.ResultModel
import kotlinx.coroutines.flow.Flow


@Dao
interface SongsDao {


    @Query("SELECT * FROM SONGS_TABLE")
    fun getAllSongs() : LiveData<List<ResultModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(resultModel: List<ResultModel>)

    @Query("DELETE FROM SONGS_TABLE")
    suspend fun deleteAllSong()

}
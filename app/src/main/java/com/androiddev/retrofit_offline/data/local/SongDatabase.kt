package com.androiddev.retrofit_offline.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androiddev.retrofit_offline.data.entities.ResultModel

@Database(entities = [ResultModel::class],version = 1)
abstract class SongDataBase : RoomDatabase(){
    abstract fun songDao():SongsDao
}
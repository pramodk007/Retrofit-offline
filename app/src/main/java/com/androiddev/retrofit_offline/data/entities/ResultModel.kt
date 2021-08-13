package com.androiddev.retrofit_offline.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "songs_table")
data class ResultModel (

    @SerializedName("artistName")
    @Expose
    val artistName: String = "",

    @PrimaryKey
    @SerializedName("trackName")
    @Expose
    val trackName: String = "",

    @SerializedName("previewUrl")
    @Expose
    val previewUrl: String = "",

    @SerializedName("artworkUrl100")
    @Expose
    val artworkUrl100: String = ""
)
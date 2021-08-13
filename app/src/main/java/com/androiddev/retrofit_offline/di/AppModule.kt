package com.androiddev.retrofit_offline.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.androiddev.retrofit_offline.data.local.SongDataBase
import com.androiddev.retrofit_offline.data.network.SongServiceApi
import com.androiddev.retrofit_offline.data.network.SongServiceImplementation
import com.androiddev.retrofit_offline.data.repository.SongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideUrl():String = "https://itunes.apple.com/"

    @Singleton
    @Provides
    fun provideRetrofit(url:String) : Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideSongService(retrofit: Retrofit): SongServiceApi = retrofit.create(SongServiceApi::class.java)

    @Singleton
    @Provides
    fun provideSongServiceImplementation(songServiceApi: SongServiceApi) = SongServiceImplementation(songServiceApi)

    @Provides
    @Singleton
    fun provideDataBase(app: Application):SongDataBase =
        Room.databaseBuilder(app, SongDataBase::class.java,"song_database")
            .build()


}
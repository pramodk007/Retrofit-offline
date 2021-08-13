package com.androiddev.retrofit_offline.ui.songs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddev.retrofit_offline.data.repository.SongRepository
import javax.inject.Inject

class SongViewModelFactory @Inject constructor(private val repository: SongRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SongViewModel(repository) as T
    }

}
package com.androiddev.retrofit_offline.ui.songs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.retrofit_offline.data.entities.ResultModel
import com.androiddev.retrofit_offline.data.entities.SearchResultModel
import com.androiddev.retrofit_offline.data.repository.SongRepository
import com.androiddev.retrofit_offline.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(private val songRepository: SongRepository): ViewModel() {

    var song:LiveData<Resource<List<ResultModel>>>? = null

    fun getSong(key:String){
        viewModelScope.launch {
            try {
                 song = songRepository.getSongs(key)
            }
            catch(e: Exception){

                Log.d("error message",e.toString())
            }
        }
    }
}
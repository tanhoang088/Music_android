package com.example.musicplayer_android.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer_android.R
import com.example.musicplayer_android.ui.model.Album

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _listDataAlbum = MutableLiveData<MutableList<Album>>().apply{
        value
    }
    val listDataAlbum : LiveData<MutableList<Album>> = _listDataAlbum

    fun fetchDataAlbum(){
        var listData : MutableList<Album> = mutableListOf()
        listData.add(Album("RAP", R.drawable.mask))
        listData.add(Album("ROCK", R.drawable.mask_rock))
        listData.add(Album("DANCE", R.drawable.mask_dance))
        listData.add(Album("BLUES", R.drawable.mask_blue))
        listData.add(Album("JAZZ", R.drawable.mask_jazz))
        listData.add(Album("R&B", R.drawable.mask))
        listData.add(Album("POP", R.drawable.mask_blue))
        _listDataAlbum.postValue(listData)
    }

}


package com.example.musicplayer_android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer_android.R
import com.example.musicplayer_android.ui.model.Album
import com.example.musicplayer_android.ui.model.RecentListeningAlbum
import com.example.musicplayer_android.ui.model.RecommendAlbum
import com.example.musicplayer_android.ui.model.TopAlbum

class HomeViewModel : ViewModel() {
    private val _listDataRecommend = MutableLiveData<MutableList<RecommendAlbum>>().apply{
        value
    }
    private val _listDataRecentListening = MutableLiveData<MutableList<RecentListeningAlbum>>().apply {
        value
    }
    private val _listDataTopAlbum = MutableLiveData<MutableList<TopAlbum>>().apply {
        value
    }

    val listDataRecommend : MutableLiveData<MutableList<RecommendAlbum>> = _listDataRecommend
    val listDataRecentListeningAlbum : MutableLiveData<MutableList<RecentListeningAlbum>> = _listDataRecentListening
    val listDataTopAlbum : MutableLiveData<MutableList<TopAlbum>> = _listDataTopAlbum

    fun fetchData(){
        var listData : MutableList<RecommendAlbum> = mutableListOf()
        var listData2 : MutableList<RecentListeningAlbum> = mutableListOf()
        var listData3 : MutableList<TopAlbum> = mutableListOf()

        listData.add(RecommendAlbum("Night Vocal", R.drawable.mask1, "30 songs . 1 hour 0 min"))
        listData.add(RecommendAlbum("Dance All Night", R.drawable.mask1, "10 songs . 0 hour 45 min"))
        listData.add(RecommendAlbum("Home Sweet Home", R.drawable.mask1, "10 songs . 0 hour 45 min"))
        listData.add(RecommendAlbum("You are the Reason", R.drawable.mask1, "10 songs . 0 hour 45 min"))
        listData.add(RecommendAlbum("Sunroof", R.drawable.mask1, "10 songs . 0 hour 45 min"))
        _listDataRecommend.postValue(listData)

        listData2.add(RecentListeningAlbum("1","Redbone"))
        listData2.add(RecentListeningAlbum("2","3005"))
        listData2.add(RecentListeningAlbum("3","Les"))
        listData2.add(RecentListeningAlbum("4","Home"))
        listData2.add(RecentListeningAlbum("5","Play"))
        listData2.add(RecentListeningAlbum("6","Study"))

        _listDataRecentListening.postValue((listData2))

        listData3.add(TopAlbum(R.drawable.albumcover11,"Awaken"))
        listData3.add(TopAlbum(R.drawable.albumcover11,"Feel Good"))
        listData3.add(TopAlbum(R.drawable.albumcover11,"Lofi"))
        listData3.add(TopAlbum(R.drawable.albumcover11,"Birthday"))
        listData3.add(TopAlbum(R.drawable.albumcover22,"My Love"))
        _listDataTopAlbum.postValue(listData3)
    }
}
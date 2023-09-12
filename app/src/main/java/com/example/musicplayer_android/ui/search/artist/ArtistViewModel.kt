package com.example.musicplayer_android.ui.search.artist
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer_android.R
import com.example.musicplayer_android.ui.model.RecentListeningAlbum
import com.example.musicplayer_android.ui.model.RecommendAlbum
import com.example.musicplayer_android.ui.model.TopAlbum

class ArtistViewModel : ViewModel() {
    private val _listBestAlbum = MutableLiveData<MutableList<TopAlbum>>().apply {
        value
    }
    private val _listPopularTrack = MutableLiveData<MutableList<RecentListeningAlbum>>().apply {
        value
    }

    val listBestAlbum : MutableLiveData<MutableList<TopAlbum>> = _listBestAlbum
    val listPopularTrack : MutableLiveData<MutableList<RecentListeningAlbum>> = _listPopularTrack

    fun fetchData(){
        var listData : MutableList<TopAlbum> = mutableListOf()
        var listData2 : MutableList<RecentListeningAlbum> = mutableListOf()

        listData.add(TopAlbum(R.drawable.topalbum1,"Awaken, My Love"))
        listData.add(TopAlbum(R.drawable.topalbum2, "Because of The ..."))
        listData.add(TopAlbum(R.drawable.topalbum1, "Feels the Way"))
        listData.add(TopAlbum(R.drawable.topalbum2, "You are the reason"))
        listData.add(TopAlbum(R.drawable.topalbum1, "Comethru"))
        _listBestAlbum.postValue(listData)

        listData2.add(RecentListeningAlbum("1","Redbone"))
        listData2.add(RecentListeningAlbum("2","3005"))
        listData2.add(RecentListeningAlbum("3","Les"))
        listData2.add(RecentListeningAlbum("4","Perfect"))
        listData2.add(RecentListeningAlbum("5","Sugar"))
        listData2.add(RecentListeningAlbum("6","Happy"))
        listData2.add(RecentListeningAlbum("7","Country"))
        listData2.add(RecentListeningAlbum("8","Old Town Road"))
        listData2.add(RecentListeningAlbum("9","Combine"))
        listData2.add(RecentListeningAlbum("10","Boat"))

        _listPopularTrack.postValue(listData2)
    }
}
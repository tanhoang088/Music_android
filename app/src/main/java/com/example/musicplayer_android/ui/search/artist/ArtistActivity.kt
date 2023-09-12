package com.example.musicplayer_android.ui.search.artist

import com.example.musicplayer_android.databinding.ActivityArtistBinding
import com.example.musicplayer_android.ui.model.RecentListeningAlbum
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer_android.ui.model.TopAlbum

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding
    private lateinit var viewModel: ArtistViewModel

    lateinit var mBestAlbumAdapter: BestAlbumAdapter
    lateinit var mPopularTrackAdapter: PopularTrackAdapter

    var mListBestAlbum: MutableList<TopAlbum> = mutableListOf()
    var mPopularTrack: MutableList<RecentListeningAlbum> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ArtistViewModel::class.java)

        bestAlbumfetch()
        popularTrackfetch()
        back()
    }
    fun bestAlbumfetch(){
        val mBestAlbumRecyclerView: RecyclerView = binding.listBestAlbum
        mBestAlbumAdapter = BestAlbumAdapter(this, mListBestAlbum)
        viewModel.fetchData()
        mBestAlbumRecyclerView.adapter = mBestAlbumAdapter
        mBestAlbumRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewModel.listBestAlbum.observe(this, Observer {
            mListBestAlbum.clear()
            mListBestAlbum.addAll(it)
            mBestAlbumAdapter.notifyDataSetChanged()
        })
    }
    fun popularTrackfetch(){
        val mPopularTrackRecyclerView: RecyclerView = binding.listPopularTrack
        mPopularTrackAdapter = PopularTrackAdapter(this, mPopularTrack)
        viewModel.fetchData()
        mPopularTrackRecyclerView.adapter = mPopularTrackAdapter
        mPopularTrackRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.listPopularTrack.observe(this, Observer {
            mPopularTrack.clear()
            mPopularTrack.addAll(it)
            mPopularTrackAdapter.notifyDataSetChanged()
        })
    }
    private fun back() {
        val imgbtnBack = binding.imgbtnBack
        imgbtnBack.setOnClickListener { finish() }
    }
}

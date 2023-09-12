package com.example.musicplayer_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer_android.databinding.FragmentHomeBinding
import com.example.musicplayer_android.ui.model.RecentListeningAlbum
import com.example.musicplayer_android.ui.model.RecommendAlbum
import com.example.musicplayer_android.ui.model.TopAlbum

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var homeViewModel: HomeViewModel
    lateinit var mRecommendAdapter: RecommendAdapter
    lateinit var mRecentListenAdapter: RecentListenAdapter
    lateinit var mTopAlbumAdapter: TopAlbumAdapter

    var mListRecommendAlbum: MutableList<RecommendAlbum> = mutableListOf()
    var mListRecentListeningAlbum: MutableList<RecentListeningAlbum> = mutableListOf()
    var mListTopAlbum: MutableList<TopAlbum> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val mRecommendRecyclerView: RecyclerView = binding.recommendationList
        val mRecentRecyclerView: RecyclerView = binding.recentListenList
        val mTopAlbumRecyclerView: RecyclerView = binding.topAlbumList

        mRecommendAdapter = RecommendAdapter(requireContext(), mListRecommendAlbum)
        mRecentListenAdapter = RecentListenAdapter(requireContext(), mListRecentListeningAlbum)
        mTopAlbumAdapter = TopAlbumAdapter(requireContext(), mListTopAlbum)

        mRecommendRecyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mRecentRecyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mTopAlbumRecyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        mRecommendRecyclerView.adapter = mRecommendAdapter
        mRecentRecyclerView.adapter = mRecentListenAdapter
        mTopAlbumRecyclerView.adapter = mTopAlbumAdapter

        homeViewModel.listDataRecommend.observe(viewLifecycleOwner) {
            mListRecommendAlbum.clear()
            mListRecommendAlbum.addAll(it)
            mRecommendAdapter.notifyDataSetChanged()
        }
        homeViewModel.listDataRecentListeningAlbum.observe(viewLifecycleOwner) {
            mListRecentListeningAlbum.clear()
            mListRecentListeningAlbum.addAll(it)
            mRecentListenAdapter.notifyDataSetChanged()
        }
        homeViewModel.listDataTopAlbum.observe(viewLifecycleOwner) {
            mListTopAlbum.clear()
            mListTopAlbum.addAll(it)
            mTopAlbumAdapter.notifyDataSetChanged()
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
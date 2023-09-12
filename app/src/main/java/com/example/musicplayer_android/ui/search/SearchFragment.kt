package com.example.musicplayer_android.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer_android.databinding.FragmentSearchBinding
import com.example.musicplayer_android.ui.interfaces.OnItemClickListener
import com.example.musicplayer_android.ui.model.Album

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    lateinit var searchViewModel: SearchViewModel
    lateinit var mSearchAdapter: SearchAdapter
    var mListData: MutableList<Album> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val mEditSearch: AppCompatEditText = binding.searchBar

        val mRecyclerView: RecyclerView = binding.mRecycleView
        mRecyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        mSearchAdapter = SearchAdapter(requireActivity(), mListData, object : OnItemClickListener {
            override fun onItemClick(position: Int) {

            }

        })
        mRecyclerView.adapter = mSearchAdapter
        searchViewModel.listDataAlbum.observe(viewLifecycleOwner) {
            mListData.clear()
            mListData.addAll(it)
            mSearchAdapter.notifyDataSetChanged()
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel.fetchDataAlbum()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
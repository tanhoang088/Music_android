package com.example.musicplayer_android.ui.search

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.musicplayer_android.R
import com.example.musicplayer_android.ui.interfaces.OnItemClickListener
import com.example.musicplayer_android.ui.model.Album
import com.example.musicplayer_android.ui.search.artist.ArtistActivity

class SearchAdapter(
    val context: Context,
    val mListData : MutableList<Album>,
    val dataList: OnItemClickListener
) : RecyclerView.Adapter<SearchAdapter.ItemAlbumViewHolder>(){
    class ItemAlbumViewHolder(itemView: View) : ViewHolder(itemView) {
        val mTextNameMusic : TextView = itemView.findViewById(R.id.mTxtNameSong)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item_album, parent,false)
        return ItemAlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAlbumViewHolder, position: Int) {
        holder.mTextNameMusic.text = mListData[position].txtTitle
        holder.mTextNameMusic.setBackgroundResource(mListData[position].imageTitle)
        holder.itemView.setOnClickListener {
            val _context=holder.mTextNameMusic.context
            val intent = Intent(_context, ArtistActivity::class.java)
            _context.startActivity(intent)
        }
    }

    override fun getItemCount() = mListData.size}
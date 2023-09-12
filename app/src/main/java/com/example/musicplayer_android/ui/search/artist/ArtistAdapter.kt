package com.example.musicplayer_android.ui.search.artist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.musicplayer_android.R
import com.example.musicplayer_android.ui.model.RecentListeningAlbum
import com.example.musicplayer_android.ui.model.TopAlbum

class BestAlbumAdapter(
    val context: ArtistActivity,
    val mListBestAlbum: MutableList<TopAlbum>
) : RecyclerView.Adapter<BestAlbumAdapter.BestAlbumViewHolder>() {
    class BestAlbumViewHolder(itemView : View) : ViewHolder(itemView){
        val mBestAlbumImage : ImageView = itemView.findViewById(R.id.topAlbumImage)
        val mBestAlbumName : TextView = itemView.findViewById(R.id.txtTopAlbum)
        val mBestAlbumDetail : TextView = itemView.findViewById(R.id.txtAlbumDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestAlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item_topalbums,parent,false)
        return BestAlbumAdapter.BestAlbumViewHolder(view)
    }

    override fun getItemCount() = mListBestAlbum.size

    override fun onBindViewHolder(holder: BestAlbumViewHolder, position: Int) {
        holder.mBestAlbumImage.setBackgroundResource(mListBestAlbum[position].albumImage)
        holder.mBestAlbumName.text = mListBestAlbum[position].albumName
    }
}

class PopularTrackAdapter(
    val context: ArtistActivity,
    val mListPopularTrack : MutableList<RecentListeningAlbum>
) : RecyclerView.Adapter<PopularTrackAdapter.PopularTrackViewHolder>(){
    class PopularTrackViewHolder(itemView: View) : ViewHolder(itemView){
        val mPopularTrackNo : TextView = itemView.findViewById(R.id.numberOrder)
        val mPopularTrackDetail : TextView = itemView.findViewById(R.id.recentListenDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularTrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item_recentlisten,parent,false)
        return PopularTrackViewHolder(view)
    }

    override fun getItemCount() = mListPopularTrack.size

    override fun onBindViewHolder(holder: PopularTrackViewHolder, position: Int) {
        holder.mPopularTrackNo.text = mListPopularTrack[position].numberOrder
        holder.mPopularTrackDetail.text = mListPopularTrack[position].songDetail
    }
}
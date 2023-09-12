package com.example.musicplayer_android.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.musicplayer_android.R
import com.example.musicplayer_android.ui.model.RecentListeningAlbum
import com.example.musicplayer_android.ui.model.RecommendAlbum
import com.example.musicplayer_android.ui.model.TopAlbum

class RecommendAdapter (
    val context : Context,
    val mListDataRecommendAlbum: MutableList<RecommendAlbum>,
    ) : RecyclerView.Adapter<RecommendAdapter.ItemAlbumViewHolder>(){
        class ItemAlbumViewHolder(itemView : View) : ViewHolder(itemView){
            val mRecommendImage : ImageView = itemView.findViewById(R.id.imgRecommend)
            val mTxtRecommend : TextView = itemView.findViewById(R.id.txtRecommend)
            val mTxtRecommendDetail : TextView = itemView.findViewById(R.id.detailRecommend)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item_recommendation, parent, false)
        return ItemAlbumViewHolder(view)
    }

    override fun getItemCount() = mListDataRecommendAlbum.size

    override fun onBindViewHolder(holder: ItemAlbumViewHolder, position: Int) {
        holder.mRecommendImage.setBackgroundResource(mListDataRecommendAlbum[position].imageTitle)
        holder.mTxtRecommend.text = mListDataRecommendAlbum[position].txtTitle
        holder.mTxtRecommendDetail.text = mListDataRecommendAlbum[position].txtSong
    }
}

class RecentListenAdapter(
    val context: Context,
    val mListDataRecentListeningAlbum: MutableList<RecentListeningAlbum>
) : RecyclerView.Adapter<RecentListenAdapter.ItemAlbumViewHolder>(){
    class ItemAlbumViewHolder(itemView: View) : ViewHolder(itemView){
        val mNumberOrder : TextView = itemView.findViewById(R.id.numberOrder)
        val mRecentListenDetail : TextView = itemView.findViewById(R.id.recentListenDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item_recentlisten,parent,false)
        return ItemAlbumViewHolder(view)
    }

    override fun getItemCount() = mListDataRecentListeningAlbum.size

    override fun onBindViewHolder(holder: ItemAlbumViewHolder, position: Int) {
        holder.mNumberOrder.text = mListDataRecentListeningAlbum[position].numberOrder
        holder.mRecentListenDetail.text = mListDataRecentListeningAlbum[position].songDetail
    }

}

class TopAlbumAdapter(
    val context: Context,
    val mListTopAlbum: MutableList<TopAlbum>
) : RecyclerView.Adapter<TopAlbumAdapter.ItemAlbumViewHolder>(){
    class ItemAlbumViewHolder(itemView: View) : ViewHolder(itemView) {
        val mTopAlbumImage : ImageView = itemView.findViewById(R.id.topAlbumImage)
        val mTxtTopAlbum : TextView = itemView.findViewById(R.id.txtTopAlbum)
        val mTxtTopAlbumDetail : TextView = itemView.findViewById(R.id.txtAlbumDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item_topalbums,parent,false)
        return ItemAlbumViewHolder(view)
    }

    override fun getItemCount() = mListTopAlbum.size

    override fun onBindViewHolder(holder: ItemAlbumViewHolder, position: Int) {
        holder.mTopAlbumImage.setBackgroundResource(mListTopAlbum[position].albumImage)
        holder.mTxtTopAlbum.text = mListTopAlbum[position].albumName
    }

}
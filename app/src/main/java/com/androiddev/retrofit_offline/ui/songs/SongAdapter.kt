package com.androiddev.retrofit_offline.ui.songs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.retrofit_offline.data.entities.ResultModel
import com.androiddev.retrofit_offline.databinding.SongSingleRowBinding
import com.bumptech.glide.Glide

class SongAdapter(): RecyclerView.Adapter<SongAdapter.SongsViewHolder>() {

    private val items = ArrayList<ResultModel>()

    fun setData(items: ArrayList<ResultModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val binding = SongSingleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size


    class SongsViewHolder(private val binding: SongSingleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: ResultModel) {
            binding.apply {
                Glide.with(itemView)
                    .load(result.artworkUrl100)
                    .into(imgPic)
                textViewHead.text = result.trackName
                textViewDesc.text = result.artistName
            }
        }
    }


}
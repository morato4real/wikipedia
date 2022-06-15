package com.morato.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.morato.wikipedia.data.ItemPost
import com.morato.wikipedia.databinding.ItemRecyclerExploreBinding

class AdapterExplore(private val data : ArrayList<ItemPost> , val itemEvents: ItemEvents) : RecyclerView.Adapter<AdapterExplore.ExploreViewHolder>() {
    lateinit var binding: ItemRecyclerExploreBinding


    inner class ExploreViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindViews(itemPost:ItemPost){
            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)

            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetail.text = itemPost.txtDetail

            itemView.setOnClickListener {
                itemEvents.onItemClicked(itemPost)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemRecyclerExploreBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExploreViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
       return data.size
    }

}
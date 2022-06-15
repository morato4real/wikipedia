package com.morato.wikipedia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.morato.wikipedia.data.ItemPost
import com.morato.wikipedia.databinding.ItemRecyclerTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class AdapterTrend(private val data: ArrayList<ItemPost>, val itemEvents: ItemEvents) :
    RecyclerView.Adapter<AdapterTrend.TrendViewHolder>() {
    lateinit var binding: ItemRecyclerTrendBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {
            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .transform(RoundedCornersTransformation(24, 4))
                .into(binding.imgTrend)
            binding.txtTitle.text = itemPost.txtTitle
            binding.txtSubtitle.text = itemPost.txtSubtitle
            binding.txtTrend.text = itemPost.insight
            binding.txtCounter.text = (adapterPosition + 1).toString()

            itemView.setOnClickListener {
                itemEvents.onItemClicked(itemPost)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding =
            ItemRecyclerTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
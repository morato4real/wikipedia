package com.morato.wikipedia.adapter

import com.morato.wikipedia.data.ItemPost

interface ItemEvents {
    fun onItemClicked(itemPost: ItemPost)
}
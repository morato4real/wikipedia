package com.morato.wikipedia.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.morato.wikipedia.R
import com.morato.wikipedia.databinding.FragmentExploreBinding
import com.morato.wikipedia.databinding.FragmentPhotographerBinding
import com.morato.wikipedia.databinding.FragmentProfileBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


class FragmentPhotographer : Fragment() {
    lateinit var binding: FragmentPhotographerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhotographerBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val glide = Glide
            .with(requireContext())
            .load(R.drawable.img_photographer)
            .transform(RoundedCornersTransformation(16,8))
            .into(binding.imageView3)
    }
}
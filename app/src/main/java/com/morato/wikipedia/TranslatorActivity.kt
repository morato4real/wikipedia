package com.morato.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.morato.wikipedia.databinding.ActivityTranslatorBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TranslatorActivity : AppCompatActivity() {
    lateinit var binding : ActivityTranslatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTranslatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.img_translatore).transform(RoundedCornersTransformation(16,8)).into(binding.imageView3)
    }
}
package com.morato.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.morato.wikipedia.data.ItemPost
import com.morato.wikipedia.databinding.ActivityMain2Binding
import com.morato.wikipedia.fragments.SEND_DATA_TO_ACTIVITY2

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarAsli)

        binding.collapsingMain.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.fabOpenWikipedia.setOnClickListener {  }


        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_ACTIVITY2)
        if (dataPost != null){
            showData(dataPost)
        }


    }

    private fun showData(itemPost: ItemPost) {
        val glide = Glide
            .with(this)
            .load(itemPost.imgUrl)
            .into(binding.imgMainDetails)

        binding.txtTitle.text = itemPost.txtTitle
        binding.txtSubtitle.text = itemPost.txtSubtitle
        binding.txtDetails.text = itemPost.txtDetail

        binding.fabOpenWikipedia.setOnClickListener {
            val url = "https://en.wikipedia.org"
            val intent = Intent(Intent.ACTION_VIEW ,Uri.parse(url) )
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return true
    }
}
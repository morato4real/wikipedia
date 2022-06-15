package com.morato.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.snackbar.Snackbar
import com.morato.wikipedia.databinding.ActivityMainBinding
import com.morato.wikipedia.fragments.FragmentExplore
import com.morato.wikipedia.fragments.FragmentPhotographer
import com.morato.wikipedia.fragments.FragmentProfile
import com.morato.wikipedia.fragments.FragmentTrend

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolBarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    val dialog = SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                    dialog.titleText = "Alert"
                    dialog.confirmText = "Confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Wanna be a writer?"
                    dialog.setConfirmClickListener { 
                        dialog.dismiss()
                        Toast.makeText(this, "you can be a writer", Toast.LENGTH_SHORT).show()
                    }
                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }

                     dialog.show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_translator -> {
                    val intent = Intent(this , TranslatorActivity::class.java)
                    startActivity(intent)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photographer -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container,FragmentPhotographer())
                    transaction.addToBackStack(null)
                    transaction.commit()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_videoCreator -> {
                    Snackbar.make(binding.root,"NO internet",Snackbar.LENGTH_LONG)
                        .setAction("Retry"){
                            Toast.makeText(this, "Checking internet", Toast.LENGTH_SHORT).show()
                        }
                        .setActionTextColor(ContextCompat.getColor(this,R.color.white))
                        .setBackgroundTint(ContextCompat.getColor(this,R.color.blue))
                        .show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_wikimedia -> {
                    val url = "https://wikimedia.org"
                    openWebsite(url)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_wikipedia -> {
                    val url = "https://wikipedia.org"
                    openWebsite(url)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

        firstRun()


        binding.bottomNavigationMain.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragment(FragmentExplore())
                }
                R.id.menu_trend -> {
                    replaceFragment(FragmentTrend())
                }
                R.id.menu_profile -> {
                    replaceFragment(FragmentProfile())
                }
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    fun firstRun(){
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }
    fun openWebsite(url:String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_exit -> {
                onBackPressed()
            }
        }
        return true
    }

}
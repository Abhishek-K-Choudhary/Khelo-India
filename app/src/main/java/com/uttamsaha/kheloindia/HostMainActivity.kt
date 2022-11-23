package com.uttamsaha.kheloindia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class HostMainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true;

            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment(),it.title.toString())
                R.id.nav_new_tournament -> replaceFragment(NewTournamentFragment(),it.title.toString())
                R.id.nav_new_match -> replaceFragment(NewMatchFragment(),it.title.toString())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment,title:String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


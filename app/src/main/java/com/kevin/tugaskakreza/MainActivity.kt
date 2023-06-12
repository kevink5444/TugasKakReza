@file:Suppress("DEPRECATION")

package com.kevin.tugaskakreza
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        setSupportActionBar(toolbar)
        val itemList = listOf("Budi", "Adi", "Sandi", "Nando", "Nanda")
        recyclerViewAdapter = RecyclerViewAdapter(itemList)
        recyclerView.adapter = recyclerViewAdapter

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    // Tampilkan fragment Home
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.menu_search -> {
                    // Tampilkan fragment Search
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.menu_favorite -> {
                    // Tampilkan fragment Favorite
                    replaceFragment(FavoriteFragment())
                    true
                }
                R.id.menu_settings -> {
                    // Tampilkan fragment Settings
                    replaceFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }

        // Tampilkan fragment Home saat pertama kali dibuka
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
    override fun onResume() {
        super.onResume()
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if (fragment is HomeFragment) {
            fragment.updateRecyclerViewVisibility()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.appbar_favorite -> {

                true
            }

            R.id.appbar_delete -> {

                true
            }

            else -> super.onOptionsItemSelected(item)

        }

    }
}
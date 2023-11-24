package com.example.goharvest.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.goharvest.R  // Import your own R class, not android.R

class NavbarActivity : AppCompatActivity() {

    private lateinit var meowBottomNavigation: MeowBottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navbar)

        meowBottomNavigation = findViewById(R.id.meowBottom)

        // add item menu
        meowBottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.baseline_circle_notifications_24))
        meowBottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.baseline_home_24))
        meowBottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.baseline_account_circle_24))

        meowBottomNavigation.setOnShowListener { item ->
            var fragment: Fragment? = null

            when (item.id) {
                1 -> fragment = NotifikasiFragment()
                2 -> fragment = HomeFragment()
                3 -> fragment = SettingFragment()
            }

            loadFragment(fragment)
        }

        // set notification count
        meowBottomNavigation.setCount(1, "10")

        // set default
        meowBottomNavigation.show(2, true)

        meowBottomNavigation.setOnClickMenuListener { item ->
            Toast.makeText(applicationContext, "You Clicked ${item.id}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment!!)
            .commit()
    }
}

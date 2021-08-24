package com.example.valorant.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.valorant.R
import com.example.valorant.databinding.ActivityMainBinding
import com.example.valorant.ui.home.HomeFragment
import com.example.valorant.ui.setting.SettingFragment
import com.example.valorant.ui.stats.StatsFragment
import com.example.valorant.ui.store.StoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    // 바인딩 변수
    private lateinit var mBinding: ActivityMainBinding
    // Frament 변수
    private val home = HomeFragment()
    private val stats = StatsFragment()
    private val store = StoreFragment()
    private val setting = SettingFragment()
    private lateinit var  bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        // 바텀 네비게이션 컨트롤
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(mBinding.myBottomNav, navController)


        bottomNavigationView = findViewById<BottomNavigationView>(R.id.myBottomNav)

        bottomNavigationView.setupWithNavController(navController)
    }
}

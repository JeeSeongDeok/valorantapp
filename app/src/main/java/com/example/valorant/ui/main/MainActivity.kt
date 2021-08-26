package com.example.valorant.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.valorant.R
import com.example.valorant.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    // 바인딩 변수
    private lateinit var mBinding: ActivityMainBinding

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

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        // 바텀 네비게이션 컨트롤
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(mBinding.myBottomNav, navController)

        //bottomNavigationView의 id를 가져와서 클릭 리스너를 생성
        val bottomNavigationView = findViewById<View>(R.id.myBottomNav) as BottomNavigationView

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                // 메인으로 이동
                R.id.homeFragment -> {
                    changeFragment(home)
                }
                // 전적검색 이동
                R.id.statsFragment -> {
                    changeFragment(stats)
                }
                // 상점 이동
                R.id.storeFragment -> {
                    changeFragment(store)
                }
                // 설정 이동
                R.id.settingFragment ->{
                    changeFragment(setting)
                }
            }
            true
        }
    }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.my_nav_host, fragment)
            .commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
            // 101코드 -> 설정으로 select해라
            if(resultCode == 101){
                changeFragment(setting)
            }
    }

}

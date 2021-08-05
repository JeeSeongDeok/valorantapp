package com.example.valorant.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.valorant.databinding.ActivityLoginBinding
import com.example.valorant.ui.main.MainActivity

class LoginActivity: AppCompatActivity(), View.OnClickListener {
    private var mBinding: ActivityLoginBinding? = null
    // mBinding이 null이 아닌 경우 get
    private val binding get() = mBinding!!
    // view model
    private val model: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        // XML연결
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Observer
        model.idLiveData.observe(this){
            if(it.isNotEmpty()){
                binding.id.setText(it)
            }
        }
        // 연결 성공 여부
        model.resultLiveData.observe(this){
            if(it){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        // setListener
        setListener()
        // Ui Setting

    }
    fun setListener(){
        binding.login.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v){
            binding.login->{
                model.connectLogin(binding.id.text.toString(), binding.pass.text.toString())
            }
        }
    }
}
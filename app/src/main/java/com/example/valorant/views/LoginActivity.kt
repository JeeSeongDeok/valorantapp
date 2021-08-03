package com.example.valorant.views

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.example.valorant.databinding.ActivityLoginBinding
import com.example.valorant.viewmodel.LoginViewModel

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
            if(it.isEmpty()){

                binding.id.setText(it)
            }
        }
        // setListener
        setListener()
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
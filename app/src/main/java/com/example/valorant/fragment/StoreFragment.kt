package com.example.valorant.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.valorant.databinding.FragmentStoreBinding
import com.example.valorant.viewmodel.StoreViewModel

class StoreFragment: Fragment(),  View.OnClickListener{
    private var mBinding: FragmentStoreBinding? = null
    lateinit var binding: FragmentStoreBinding
    private val viewmodel: StoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        mBinding = binding



        // 클릭 리스너 설정
        binding.button.setOnClickListener(this)
        // 옵저버
        viewmodel.resultLiveData.observe(viewLifecycleOwner){
            if(it.isNotEmpty()){
                Glide.with(this)
                    .load(it[0].displayIcon)
                    .into(binding.imageView8)
                Glide.with(this)
                    .load(it[1].displayIcon)
                    .into(binding.imageView9)
                Glide.with(this)
                    .load(it[2].displayIcon)
                    .into(binding.imageView10)
                binding.imageView8.visibility = View.VISIBLE
                binding.imageView9.visibility = View.VISIBLE
                binding.imageView10.visibility = View.VISIBLE
            }
        }

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    override fun onClick(v: View?) {
        when(v){
            binding.button -> {
                viewmodel.Connect("", "")
            }
        }
    }
}
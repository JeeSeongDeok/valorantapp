package com.example.valorant.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.valorant.databinding.FragmentStoreBinding
import com.example.valorant.dialog.LoginDialog
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
        binding.connectBtn.setOnClickListener(this)
        // 옵저버
        viewmodel.resultLiveData.observe(viewLifecycleOwner){
            if(it.isNotEmpty()){
                var imgArray = arrayOf(binding.gunImageView1, binding.gunImageView2, binding.gunImageView3, binding.gunImageView4)
                var textArray = arrayOf(binding.gunTextView1, binding.gunTextView2, binding.gunTextView3, binding.gunTextView4)
                for(i in 0..3){
                    imageSet(imgArray[i], textArray[i], it[i].displayIcon, it[i].displayName)
                }
                binding.connectBtn.visibility = View.GONE
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
            binding.connectBtn -> {
                val dialog = LoginDialog(requireContext())
                dialog.callLoginDig()
                // 디아로그 클릭 리스너
                dialog.setOnClickedListener(object: LoginDialog.ButtonClickListener{
                    override fun onClicked(id: String, pw: String) {
                        viewmodel.Connect("id", "pw")
                    }

                })
            }
        }
    }
    // json파일을 이미지에 넣기 위한 작업
    private fun imageSet(image: ImageView, textWidget: TextView, imgUrl: String?, title: String?){
        Glide.with(this)
                .load(imgUrl)
                .into(image)
        textWidget.text = title
        image.visibility = View.VISIBLE
        textWidget.visibility = View.VISIBLE
    }
}
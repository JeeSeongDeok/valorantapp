package com.example.valorant.ui.loading

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.example.valorant.R

class LoadingDialog constructor(context: Context) : Dialog(context){

    init {
        // 외부에서 터치 시 종료 x
        setCanceledOnTouchOutside(false)
        // 디아로그 배경 투명화
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //
        setContentView(R.layout.dialog_loading)
    }
}
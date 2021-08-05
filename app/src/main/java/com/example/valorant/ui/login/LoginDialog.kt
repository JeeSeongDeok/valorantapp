package com.example.valorant.ui.login

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.EditText
import com.example.valorant.R

class LoginDialog (context: Context) {
    private val dialog = Dialog(context)
    private lateinit var onClickedListener: ButtonClickListener
    fun callLoginDig(){
        loginDig()
        dialog.show()
    }
    fun loginDig(){
        dialog.setContentView(R.layout.dialog_signup)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        // dialog 변수들
        val id = dialog.findViewById<EditText>(R.id.dialog_id)
        val pw = dialog.findViewById<EditText>(R.id.dialog_pw)
        val btnLogin = dialog.findViewById<Button>(R.id.dialog_login)
        // 리스너
        btnLogin.setOnClickListener{
            onClickedListener.onClicked(id.text.toString(), pw.text.toString())
            dialog.dismiss()
        }
    }
    interface ButtonClickListener{
        fun onClicked(id: String, pw: String)
    }
    fun setOnClickedListener(listener: ButtonClickListener) {
        onClickedListener = listener
    }
}
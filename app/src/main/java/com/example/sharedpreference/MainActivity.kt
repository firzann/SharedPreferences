package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var prefManager: prefmanager
    private lateinit var username: String
    private lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        checkLogin()
        setupUI()
    }

    private fun init(){
        prefManager = prefmanager(this)
        username = prefManager.getUsername().toString()
        tvData = findViewById(R.id.tv_data)
    }

    private fun checkLogin(){
        if (prefManager.isLogin() == false){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupUI(){
        tvData.text = "Selamat bergabung $username"
    }

    fun clickLogout(view: View) {
        prefManager.removeData()
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }
}
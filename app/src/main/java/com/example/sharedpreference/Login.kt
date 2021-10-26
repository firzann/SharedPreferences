package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.view.View

class Login : AppCompatActivity() {

    private lateinit var prefManager: prefmanager
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var username: String
    private lateinit var password: String

    //Simpen data user dan password
    private var validUsername = "firzan"
    private var validPassword = "lelelawar100"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        checkLogin()
    }

    private fun init(){
        prefManager = prefmanager(this)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
    }

    private fun checkLogin(){
        if (prefManager.isLogin()!!){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun clickLogin(view: View) {
        username = etUsername.text.toString().trim()
        password = etPassword.text.toString().trim()
        if (username.isEmpty() || username == ""){
            etUsername.error = "Error Harus diisi"
            etUsername.requestFocus()
        } else if (password.isEmpty() || password == ""){
            etPassword.error = "Error Harus diisi"
            etPassword.requestFocus()
        } else if (username != validUsername){
            etUsername.error = "Username belum terdaftar"
            etUsername.requestFocus()
        } else if (password != validPassword){
            etPassword.error = "Password tidak valid"
            etPassword.requestFocus()
        } else {
            prefManager.setLoggin(true)
            prefManager.setUsername(username)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
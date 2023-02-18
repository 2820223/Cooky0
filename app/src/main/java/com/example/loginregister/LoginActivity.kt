package com.example.loginregister

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private var userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type
        val users = shared.getString("users", "")

        signUpLog.setOnClickListener {
            var intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        signInLog.setOnClickListener {
            userList = gson.fromJson(users, convert)

            for (user in userList) {
                if (nameInputLog.text.toString() == user.name && passwordInputLog.text.toString() == user.password) {
                    Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    return@setOnClickListener
                }
            }

            Toast.makeText(this, "Name or Password is incorrect", Toast.LENGTH_SHORT).show()


        }
    }
}
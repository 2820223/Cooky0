package com.example.loginregister

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var userList = mutableListOf<User>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
var set_course = findViewById<Button>(R.id.set_course)
        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type
        val users = shared.getString("users", "")

        userList = gson.fromJson(users, convert)

        nameWelcome.text = userList.last().name
        set_course.setOnClickListener {
            intent = Intent(this,Set_course::class.java)
            startActivity(intent)
        }
//        passwordWelcome.text = "Password: ${userList.last().password}"
    }
}
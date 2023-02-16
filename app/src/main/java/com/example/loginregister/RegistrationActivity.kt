package com.example.loginregister

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

class RegistrationActivity : AppCompatActivity() {

    private lateinit var reg: Button
    lateinit var name: TextInputEditText
    lateinit var password: TextInputEditText
    private lateinit var userList: MutableList<User>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>() {}.type

        initUI()

        reg.setOnClickListener {
            validate()
            val users = shared.getString("users", "")
            if (users == "") {
                userList = mutableListOf()
            } else {
                userList = gson.fromJson(users, convert)
            }

            userList.add(User(name, password))

            val str = gson.toJson(userList)
            edit.putString("users", str).apply()


//            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initUI() {
        reg = findViewById(R.id.signUp)
        name = findViewById(R.id.nameInput)
        password = findViewById(R.id.passwordInput)
    }

    private fun validate() {
        if (name.equals("") || password.equals("")) {
            Toast.makeText(this, "Fill the form fully", Toast.LENGTH_SHORT).show()
        }
//        for (i in userList.indices) {
//            if (username.toString().equals(userList[i].username)) {
//                Toast.makeText(
//                    this,
//                    "User with this username already registered",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
    }
}
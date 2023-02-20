package com.example.loginregister

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class IngredientsActivity : AppCompatActivity(), View.OnClickListener {
    var tests = arrayListOf<Test>()
    var index = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ingredients)
//       var oil =  intent.getFloatExtra("oil", 0.0F)
//        var oil1 = findViewById<TextView>(R.id.oil)
//        oil1.text = (oil1.text.to(Float) + oil.toString().to(Float)).toString
    }

    override fun onClick(v: View?) {

    }
}
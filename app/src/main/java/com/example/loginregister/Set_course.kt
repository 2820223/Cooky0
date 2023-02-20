package com.example.loginregister


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import com.example.loginregister.Test
import kotlinx.android.synthetic.main.choose.*
import kotlinx.android.synthetic.main.ingredients.*

class Set_course : AppCompatActivity(), View.OnClickListener {
    var tests = arrayListOf<Test>()
    var index = 0
    var rice = 0.0
    var onion = 0.0
    var potato = 0.0
    var oil = 0.0
    var meat = 0.0
    var chicken = 0.0
    var cheese = 0.0
    var flour = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose)
        var answer_1 = findViewById<RadioButton>(R.id.answer_1)
        var answer_2 = findViewById<RadioButton>(R.id.answer_2)
        var answer_3 = findViewById<RadioButton>(R.id.answer_3)
        var answer_4 = findViewById<RadioButton>(R.id.answer_4)



        answer_1.setOnClickListener {
            next.isEnabled = answer_1.isChecked
        }
        answer_2.setOnClickListener {
            next.isEnabled = answer_2.isChecked
        }
        answer_3.setOnClickListener {
            next.isEnabled = answer_3.isChecked
        }
        answer_4.setOnClickListener {
            next.isEnabled = answer_4.isChecked
        }



        tests.add(Test("Birinchi ovqat", "Sho'rva", "Borsh", "Mastava", "Pishloqli sho'rva"))
        tests.add(Test("Ikkinchi ovqat", "Osh", "So'msa", "Shashlik", "Tovuq"))
        tests.add(Test("Salat", "Bahor salati", "Yalpizli va magoli salat", "Murjskoy kapriz", "Kimchi"))
        tests.add(Test("Dessert", "Keks", "Donut", "Napoleon Torti", "Olmali pirog"))




        createTest(index)
        testNumber(tests.size)
        next.setOnClickListener {
            if (index < tests.size - 1) {
                index++
            }
            answers.clearCheck()
            createTest(index)
            testNumber(tests.size)
        }

    }

    fun createTest(i: Int) {
        var test = tests[i]
        question.text = test.question
        answer_1.text = test.answer1
        answer_2.text = test.answer2
        answer_3.text = test.answer3
        answer_4.text = test.answer4
    }
   fun check() {

   }
    fun testNumber(n: Int) {
        for (i in 0 until 4) {
            var btn = Button(this)
            btn.id = i
            btn.text = "${i+1}"
            btn.tag = "$i"
            btn.setOnClickListener (this)
            btn.setBackgroundColor(Color.YELLOW)
            questions_number.addView(btn)
//            if(btn.text == "1"){
//                if (answer_1.isChecked){
//                    oil  += 0.1
//                    potato += 1
//                    onion += 0.5
//                    meat += 1
//                }
//            }
            if(btn.text == "4"){
next.setOnClickListener {
    intent = Intent(this,IngredientsActivity::class.java)
//    intent.putExtra("oil",oil)
//    intent.putExtra("meat",meat)
//    intent.putExtra("potato",potato)
//    intent.putExtra("onion",onion)

    startActivity(intent)
}
            }

        }
    }

    override fun onClick(p0: View?) {
        val btn = findViewById<Button>(p0!!.id)
        index = btn.tag.toString().toInt()
        createTest(index)
    }
}
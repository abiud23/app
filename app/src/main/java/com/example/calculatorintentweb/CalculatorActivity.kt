package com.example.calculatorintentweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var buttonadd:Button
    lateinit var buttonsub:Button
    lateinit var buttonmult:Button
    lateinit var buttondiv:Button
    lateinit var edit_fnum:EditText
    lateinit var edit_snum:EditText
    lateinit var text_answer:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        buttonadd=findViewById(R.id.btn_add)
        buttonsub=findViewById(R.id.btn_sub)
        buttonmult=findViewById(R.id.btn_multiply)
        buttondiv=findViewById(R.id.btn_division)
        edit_fnum=findViewById(R.id.text_first)
        edit_snum=findViewById(R.id.text_second)
        text_answer=findViewById(R.id.text_answer)


        buttonadd.setOnClickListener {
            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="PLease input all the details!!"
            }else{
                var Answer=firstnum.toDouble() + secondnum.toDouble()
                text_answer.text =Answer.toString()
            }
        }


        buttonsub.setOnClickListener {
            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="PLease input all the details!!"
            }else{
                var Answer=firstnum.toDouble() - secondnum.toDouble()
                text_answer.text =Answer.toString()
            }

        }


        buttonmult.setOnClickListener {
            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="PLease input all the details!!"
            }else{
                var Answer=firstnum.toDouble() * secondnum.toDouble()
                text_answer.text =Answer.toString()
            }

        }


        buttondiv.setOnClickListener {
            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="PLease input all the details!!"
            }else{
                var Answer=firstnum.toDouble() / secondnum.toDouble()
                text_answer.text =Answer.toString()
            }

        }

    }
}
package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener { setText("0")}
        btn_1.setOnClickListener { setText("1")}
        btn_2.setOnClickListener { setText("2")}
        btn_3.setOnClickListener { setText("3")}
        btn_4.setOnClickListener { setText("4")}
        btn_5.setOnClickListener { setText("5")}
        btn_6.setOnClickListener { setText("6")}
        btn_7.setOnClickListener { setText("7")}
        btn_8.setOnClickListener { setText("8")}
        btn_9.setOnClickListener { setText("9")}
        point.setOnClickListener { setText(".") }
        equality.setOnClickListener { setText("=") }
        division.setOnClickListener { setText("/")}
        subtraction.setOnClickListener { setText("-") }
        multiply.setOnClickListener { setText("*")}
        addition.setOnClickListener { setText("+")}
        bracket_1.setOnClickListener { setText("(")}
        bracket_2.setOnClickListener { setText(")")}
        AC.setOnClickListener {
            operationText.text = ""
            resultText.text = ""
        }
        back.setOnClickListener {
            val str = operationText.text.toString()
            if(str.isNotEmpty())
                operationText.text = str.substring(0,str.length-1)
            resultText.text=""
        }
        equality.setOnClickListener {
            try{
                val ex = ExpressionBuilder(operationText.text.toString()).build()
                val result = ex.evaluate()

                val longRes= result.toLong()
                if(result == longRes.toDouble())
                    resultText.text = longRes.toString()
                else
                    resultText.text=result.toString()

            }
            catch(e:Exception){
                Log.d("Ошибка!", "сообщение: ${e.message}")
            }
        }
    }

    fun setText(str: String) {
        if (resultText.text!="") {
            operationText.text=resultText.text
            resultText.text=""
        }
        operationText.append(str)
    }

}
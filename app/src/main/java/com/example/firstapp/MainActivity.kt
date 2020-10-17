package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var isMinus = false
    var isPlus = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getResult()
        setPlusOperator()
        setMinusOperator()
    }

    private fun getResult() {
        count_button.setOnClickListener() {
            val first: Int = first_edit_text.text.toString().toInt()
            val second: Int = second_edit_text.text.toString().toInt()
            var result: Int = first + second

            if (isMinus) result = first - second
            else result = first + second

            first_edit_text.text.clear()
            second_edit_text.text.clear()
            result_text_view.text = result.toString()
        }
    }

    private fun setPlusOperator() {
        plus_button.setOnClickListener {
            isPlus = false
        }
    }

    private fun setMinusOperator() {
        minus_button.setOnClickListener {
            isMinus = true
        }
    }
}

// var createdName: String = "RAMEO"

//fun getName(age: Int): String {
//return createdName + age
//}

//fun getlastName(age: Int): String {
//  return createdName + age
//}

//fun gefirsttName(age: Int): String {
//   return createdName + age
// }

/*
1.  Всегда следить за пробелами и отступами
2.  Всегда логически называть переменнные и методы
//  var a, d, egeff - плохо
//  var Name, LastName, age - ояень хорошо!
*/

//  var age: Int = 40
//  var isMarried: Boolean = false
//  var size: Short = 35
//  var leght: Byte = 4
//  var weght: Double = 3.785

//  var - переменная, age - название
//  var - : Init - наследование или принадлежность к определенному типу
//  var =  40 - значение

//  Что такое переменная - это Ячейка памяти для хранения памяти
//  Int, Boolean, Double, String, float, char

/*  RES */
//  Drawable - Векторные // svg, pdf
//  layout - Растровые // jpeg, jpg, png, gif
//  mipmap - Скрины, списки
//  values - Переводы строк, цвета, стили, размеры

/*  Gradle_Scripts */
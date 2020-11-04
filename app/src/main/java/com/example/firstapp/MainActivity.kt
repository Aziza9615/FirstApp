package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.constrant_layout.*
import java.util.ArrayList
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var enteredNumber: Double = 0.0
    private var operand = ""
    private var default = ""
    private var lastNumber = ""
    private val desimalArrayButtons = mutableListOf<Button>()
    private val operandArrayButtons = mutableListOf<Button>()
    private val egualsArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "calculator"
        setDesimalButtonsToArray()
        setDesimalButton()

        setOperandButtonsToArray()
        setOperandAllButton()

        btnClear()
        btnEguals()
        btnRemoveLast()
        btnOpenList ()
    }

    private fun btnOpenList() {
        send_egual_btn.setOnClickListener {
            val intent = Intent(this, ListOfEgualsAcivity::class.java)
            intent.putStringArrayListExtra("lais", egualsArray as ArrayList<String>)
            startActivity(intent)
        }
    }

    private fun setDesimalButtonsToArray() {
        desimalArrayButtons.apply {
            add(btn_0)
            add(btn_1)
            add(btn_2)
            add(btn_3)
            add(btn_4)
            add(btn_5)
            add(btn_6)
            add(btn_7)
            add(btn_8)
            add(btn_9)
            add(btn_dot)
        }
    }

    private fun setDesimalButton() {
        for (btn in desimalArrayButtons) {
            btn.setOnClickListener {
                default = result.text.toString()
                default += btn.text
                lastNumber += btn.text
                result.text = default
            }
        }
    }

    private fun setOperandButtonsToArray() {
        operandArrayButtons.apply {
            add(btn_minus)
            add(btn_plus)
            add(btn_pow)
            add(btn_division)
        }
    }

    private fun setOperandAllButton() {
        for (btn in operandArrayButtons) {
            btn.setOnClickListener { operandWorker(btn.text.toString()) }
        }
    }

    private fun isDesimal(last: Char): Boolean {
        val charArray = mutableListOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

        for (char in charArray) {
            if (last == char) return true
        }
        return false
    }


    private fun btnClear() {
        btn_delete.setOnClickListener {
            enteredNumber = 0.0
            lastNumber = ""
            result.text = ""
        }
    }

    private fun btnDot() {
        btn_dot.setOnClickListener {
            default = result.text.toString()
            default += "."
            lastNumber += "."
            result.text = default
        }
    }

    private fun operandWorker(type: String) {
        var text = result.text.toString()
        if (text. isNullOrEmpty()) { return }
        default = result.text.toString()
        if (isDesimal(default.last())) {
            if (enteredNumber == 0.0) enteredNumber += lastNumber.toDouble()
            lastNumber = ""
        } else {
        default = default.dropLast(1)
    }
            default += type
            result.text = default
            operand = type
        }


    private fun btnRemoveLast() {
        btn_remove.setOnClickListener {
            if (default.isNotEmpty()) {
                default = default.dropLast(1)
                result.text = default
            }
        }
    }

        private fun btnEguals() {
            btn_eguals.setOnClickListener {
                if (operand == "*") enteredNumber *= lastNumber.toDouble()
                else if (operand == "/") enteredNumber /= lastNumber.toDouble()
                else if (operand == "+") enteredNumber += lastNumber.toDouble()
                else if (operand == "-") enteredNumber -= lastNumber.toDouble()

                displayResult()
            }
        }

    private fun displayResult() {
        egualsArray.add(enteredNumber.toString())
        if (enteredNumber % 1 == 0.0) result.text = enteredNumber.roundToInt().toString()
        else result.text = String.format("%.2f", enteredNumber)
        lastNumber = ""
    }

        private fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }









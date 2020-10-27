package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1()
        btn2()
        btn3()
        btn4()
        btn5()
        btn6()
        btn7()
        btn8()
        btn9()
        btn0()
        btnClear()
        btnOpenParent()
        btnCloseParent()
        btnPercent()
        btnMultiply()
        btnMinus()
        btnPlus()
        btnDivision()
        btnZapata()
        btneguals()

    }

    private fun btn0() {
        btn_0.setOnClickListener {
            var default: String = result.text.toString()
            default += "0"
            result.text = default
        }
    }

    private fun btn1(){
        btn_1.setOnClickListener {
            var default:String = result.text.toString()
            default += "1"
            result.text = default
        }
    }

    private fun btn2() {
        btn_2.setOnClickListener {
            var default: String = result.text.toString()
            default += "2"
            result.text = default
        }
    }

    private fun btn3() {
        btn_3.setOnClickListener {
            var default: String = result.text.toString()
            default += "3"
            result.text = default
        }
    }

    private fun btn4() {
        btn_4.setOnClickListener {
            var default: String = result.text.toString()
            default += "4"
            result.text = default
        }
    }

    private fun btn5() {
        btn_5.setOnClickListener {
            var default: String = result.text.toString()
            default += "5"
            result.text = default
        }
    }

    private fun btn6() {
        btn_6.setOnClickListener {
            var default: String = result.text.toString()
            default += "6"
            result.text = default
        }
    }

    private fun btn7() {
        btn_7.setOnClickListener {
            var default: String = result.text.toString()
            default += "7"
            result.text = default
        }
    }

    private fun btn8() {
        btn_8.setOnClickListener {
            var default: String = result.text.toString()
            default += "8"
            result.text = default
        }
    }

    private fun btn9() {
        btn_9.setOnClickListener {
            var default: String = result.text.toString()
            default += "9"
            result.text = default
        }
    }

    private fun btnClear() {
        btn_delete.setOnClickListener {
            var default: String = result.text.clear()
            default += "AC"
            result.text = default
        }
    }

    private fun btnOpenParent() {
        btn_open_parent.setOnClickListener {
            var default: String = result.text.toString()
            default += "("
            result.text = default
        }
    }

    private fun btnCloseParent() {
        btn_close_parent.setOnClickListener {
            var default: String = result.text.toString()
            default += ")"
            result.text = default
        }
    }

    private fun btnPercent() {
        btn_percent.setOnClickListener {
            var default: String = result.text.toString()
            default += "%"
            result.text = default
        }
    }

    private fun btnMultiply() {
        btn_multiply.setOnClickListener {
            var default: String = result.text.toString()
            default += "*"
            result.text = default
        }
    }

    private fun btnMinus() {
        btn_minus.setOnClickListener {
            var default: String = result.text.toString()
            default += "-"
            result.text = default
        }
    }

    private fun btnPlus() {
        btn_plus.setOnClickListener {
            var default: String = result.text.toString()
            default += "+"
            result.text = default
        }
    }

    private fun btnDivision() {
        btn_division.setOnClickListener {
            var default: String = result.text.toString()
            default += "/"
            result.text = default
        }
    }

    private fun btnZapata() {
        btn_zapata.setOnClickListener {
            var default: String = result.text.toString()
            default += ","
            result.text = default
        }
    }

    private fun btneguals() {
        btn_eguals.setOnClickListener {
            var default: String = result.text.toString()
            default += "="
            result.text = default
        }
    }



    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

private fun CharSequence.clear(): String {
    TODO("Not yet implemented")
}









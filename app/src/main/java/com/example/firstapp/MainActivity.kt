package com.example.firstapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.constrant_layout.*

class MainActivity : AppCompatActivity() {

    val imageArray: MutableList<Int> = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constrant_layout)
        changeIconAction()

    }

    private fun changeIconAction() {
        change_image.setOnClickListener {
            val imageArray =
                arrayOf(R.mipmap.djakarta,R.mipmap.kaliforniya,R.mipmap.chehiya, R.mipmap.horvatiya, R.mipmap.italy, R.mipmap.spain, R.mipmap.peterburg, R.mipmap.tokyo, R.mipmap.turciya)

            val imageRandom = imageArray.random()
            image_view.setImageResource(imageRandom)
        }
    }
}

//            val number: Int = (0..1000).random()
//            showToast("Рандомное число равно = $number")
//        }
//
//    }
//
//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
//    }
//
//}



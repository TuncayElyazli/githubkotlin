package com.example.evtapsirigi10

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var firstNumberTxt: EditText
    lateinit var lastNumberTxt: EditText
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        firstNumberTxt= findViewById(R.id.editTextfirstnmbr)
        lastNumberTxt= findViewById(R.id.editTextlastnmbr)
        val topla: Button = findViewById(R.id.btntopla)
        val cix: Button = findViewById(R.id.btncix)
        val hasil :Button=findViewById(R.id.Hasil)
        val bolme : Button = findViewById(R.id.bolme)


        topla.setOnClickListener {
            val firstNumber = firstNumberTxt.text.toString().toDouble()
            val lastNumber = lastNumberTxt.text.toString().toDouble()

            var cem = firstNumber + lastNumber
            var cavab: TextView = findViewById(R.id.cavab)
            cavab.text = cem.toString()

        }
        cix.setOnClickListener {
            val firstNumber = firstNumberTxt.text.toString().toDouble()
            val lastNumber = lastNumberTxt.text.toString().toDouble()

            var ferg = firstNumber - lastNumber
            var cavab: TextView = findViewById(R.id.cavab)
            cavab.text = ferg.toString()
        }
        hasil.setOnClickListener {
            val firstNumber = firstNumberTxt.text.toString().toDouble()
            val lastNumber = lastNumberTxt.text.toString().toDouble()

            var hasil = firstNumber * lastNumber
            var cavab: TextView = findViewById(R.id.cavab)
            cavab.text = hasil.toString()
        }
        bolme.setOnClickListener {
            val firstNumber = firstNumberTxt.text.toString().toDouble()
            val lastNumber = lastNumberTxt.text.toString().toDouble()

            var bolme = firstNumber / lastNumber
            var cavab: TextView = findViewById(R.id.cavab)
            cavab.text = bolme.toString()
            if(lastNumber==0.0){
                val lastNumber = lastNumberTxt.text.toString().toDouble()
                println("Xeta,yeniden cehd edin")

            }
        }
    }fun cem(operator:String){
        val firstNumber = firstNumberTxt.text.toString().toDouble()
        val lastNumber = lastNumberTxt.text.toString().toDouble()
        var cem :Double =
            when(operator){
                "+" -> firstNumber+lastNumber
                "-" -> firstNumber-lastNumber
                else -> 0.0

            }


    }

}
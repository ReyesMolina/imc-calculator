package com.reyesm.sumador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.editTextNumber1)
        val editText2 = findViewById<EditText>(R.id.editTextNumber2)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            val num1String = editText1.text.toString()
            val num2String = editText2.text.toString()

            if (num1String.isEmpty() || num2String.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    val num1 = num1String.toDouble()
                    val num2 = num2String.toDouble()
                    val sum = num1/((num2/100)*(num2/100))
                    val df = DecimalFormat("#.##")
                    val imc = df.format(sum)

                    resultTextView.text = imc.toString()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor, ingresa solo números", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}
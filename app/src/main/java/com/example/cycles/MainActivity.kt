package com.example.cycles

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cycles.ui.theme.CyclesTheme

//Вариант 5. Дано натуральное число n. Вычислить:
//1/1!+1/2!+1/3!+..+1/n!,
//где n!=1*2*3*..*n

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView (R.layout.activity_main)

        val valueN: EditText = findViewById(R.id.valueN)
        val calc: Button = findViewById(R.id.calc)
        val result: TextView = findViewById(R.id.result)

        calc.setOnClickListener(){
            val n = valueN.text.toString().toIntOrNull()

            if (n==null || n<1){
                result.text = "Введите натуральное число n>=1"
                return@setOnClickListener
            }

            var factorial = 1L
            var sum = 0.0

            for(i in 1..n){
                factorial = factorial * i
                sum = sum + 1.0/factorial
            }

            result.text = "Полученная сумма = $sum"
        }
    }
}
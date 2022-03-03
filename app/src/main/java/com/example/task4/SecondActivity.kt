package com.example.task4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task4.databinding.ActivityMainBinding
import com.example.task4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button1=binding.buttonOne
        val button2=binding.buttonTwo
        val button3=binding.buttonThree
        button1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data",1)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data",2)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        button3.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data",3)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
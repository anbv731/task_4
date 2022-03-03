package com.example.task4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.task4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button=binding.buttonId
         image=binding.imageViewId

        button.setOnClickListener{openActivityForResult()}
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Int? = result.data?.extras?.getInt("data")
            when (data){
                1-> image.setImageDrawable(getDrawable(R.drawable.one))
                2-> image.setImageDrawable(getDrawable(R.drawable.two))
                3-> image.setImageDrawable(getDrawable(R.drawable.three))
            }
        }
    }

    private fun openActivityForResult() {
        val intent = Intent(this, SecondActivity::class.java)
        resultLauncher.launch(intent)
    }
}
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
    private var selectedNumber = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button = binding.buttonId
        image = binding.imageViewId
        if (savedInstanceState != null) {
            selectedNumber = savedInstanceState.getInt("savedNumber")
            setImage(selectedNumber)
        }

        button.setOnClickListener { openActivityForResult() }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("savedNumber", selectedNumber)
        super.onSaveInstanceState(outState)
    }


    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Int? = result.data?.extras?.getInt("data")
                setImage(data)
            }
        }

    private fun openActivityForResult() {
        val intent = Intent(this, SecondActivity::class.java)
        resultLauncher.launch(intent)
    }

    private fun setImage(imageNum: Int?) {
        when (imageNum) {
            1 -> {
                image.setImageDrawable(getDrawable(R.drawable.one))
                selectedNumber = 1
            }

            2 -> {
                image.setImageDrawable(getDrawable(R.drawable.two))
                selectedNumber = 2
            }
            3 -> {
                image.setImageDrawable(getDrawable(R.drawable.three))
                selectedNumber = 3
            }
        }
    }

}
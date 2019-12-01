package com.example.component_important_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToastMe.setOnClickListener {
            Toast.makeText(this,"Toast Notification",Toast.LENGTH_LONG).show()
        }
    }
}

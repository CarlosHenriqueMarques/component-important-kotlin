package com.example.component_important_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToastMe.setOnClickListener {
           val toast =  Toast.makeText(this,"Toast Notification",Toast.LENGTH_LONG)

            //Customizando a cor da mensagem dentro do Toast
            //toast.view.findViewById<TextView>(android.R.id.message).setTextColor(Color.GREEN)

            //Usando o toast customizado (icone e cor)
            val toastCustom = layoutInflater.inflate(R.layout.toast_custom, null)
            toast.view = toastCustom
            val textview = toast.view.findViewById<TextView>(R.id.txtMessage)
            textview.text = "Toast Customizada"

            toast.show()
        }
    }
}

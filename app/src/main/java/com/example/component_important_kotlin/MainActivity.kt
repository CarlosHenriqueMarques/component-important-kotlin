package com.example.component_important_kotlin

import android.app.ProgressDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toast_custom.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

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

        buttonSnackMe.setOnClickListener {
          val snack =  Snackbar.make(contrantLayout,"SnackBar ",Snackbar.LENGTH_LONG)
            snack.view.findViewById<TextView>(R.id.snackbar_text).setTextColor(Color.GREEN)
            snack.view.setBackgroundColor(Color.RED)
            ContextCompat.getColor(this,R.color.colorAccent)

            snack.setAction("Desfazer"){
                Snackbar.make(contrantLayout, "Ação Desfeita", Snackbar.LENGTH_SHORT).show()
            }

            snack.setActionTextColor(Color.YELLOW)
            snack.show()

        }

        //Setando o valor em um spinner
        setSpinner.setOnClickListener {
            spinnerDinamic.setSelection(2)
        }

        //Pegando o valor de um spinner
        getSpinner.setOnClickListener {
            val value = spinnerDinamic.selectedItem.toString()
            Toast.makeText(this,value,Toast.LENGTH_LONG).show()
        }

        progressDialog.setOnClickListener {
            val progress =  ProgressDialog(this)
            progress.setTitle("Titulo")
            progress.setMessage("Mensagem")
            progress.show()



            //Para fechar o progress por código
            //progress.hide()
            //progress.dismiss()

        }

        loadSpiner()
    }

    private fun loadSpiner() {
       val list =  Mock.getList()
        val adapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,list)
        spinnerDinamic.adapter = adapter
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
    //Foi feito para pegar o valor do spiner, foi convertido em string
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val value : String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,value,Toast.LENGTH_LONG).show()
    }
}

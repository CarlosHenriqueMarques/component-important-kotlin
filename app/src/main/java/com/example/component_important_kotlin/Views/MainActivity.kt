package com.example.component_important_kotlin.Views

import android.app.ProgressDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.component_important_kotlin.Mock.Mock
import com.example.component_important_kotlin.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {

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
            ContextCompat.getColor(this,
                R.color.colorAccent
            )

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

        getSeek.setOnClickListener {
            val value = seekBar.progress.toString()
            Toast.makeText(this,value,Toast.LENGTH_LONG).show()
        }
        setSeek.setOnClickListener {
            seekBar.progress = 10
        }

        loadSpiner()
    }

    private fun loadSpiner() {
       val list =  Mock.getList()
        val adapter = ArrayAdapter(this,
            R.layout.support_simple_spinner_dropdown_item,list)
        spinnerDinamic.adapter = adapter
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
    //Foi feito para pegar o valor do spiner, foi convertido em string
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val value : String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,value,Toast.LENGTH_LONG).show()
    }

    override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
        val id = seekBar.id
        if(id == R.id.seekBar){
            textbarSeekBar.text = progress.toString()
        }

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
}

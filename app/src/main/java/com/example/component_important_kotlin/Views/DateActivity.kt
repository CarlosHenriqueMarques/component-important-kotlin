package com.example.component_important_kotlin.Views

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.component_important_kotlin.R
import kotlinx.android.synthetic.main.activity_date.*
import java.text.SimpleDateFormat
import java.util.*

class DateActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private val mSimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        buttonDatePicker.setOnClickListener {
            openDatePickerDialog()
        }
    }

    private fun openDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,this,year,month,day).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year,month,dayOfMonth)
        val value = mSimpleDateFormat.format(calendar.time)
        buttonDatePicker.text = value
    }
}

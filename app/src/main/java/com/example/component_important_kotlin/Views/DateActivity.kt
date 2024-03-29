package com.example.component_important_kotlin.Views

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.component_important_kotlin.R
import kotlinx.android.synthetic.main.activity_date.*
import java.text.SimpleDateFormat
import java.util.*

class DateActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePicker.OnTimeChangedListener {

    private val mSimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        buttonDatePicker.setOnClickListener {
            openDatePickerDialog()
        }

        buttonGetTime.setOnClickListener {
            if(Build.VERSION.SDK_INT >= 23){
                val value = "${timePicker.hour} : ${timePicker.minute}"
                Toast.makeText(this, value, Toast.LENGTH_LONG).show()
            }else{
                val value = "${timePicker.currentHour} : ${timePicker.currentMinute}"
                Toast.makeText(this, value, Toast.LENGTH_LONG).show()
            }
        }

        buttonSetTime.setOnClickListener {
            if(Build.VERSION.SDK_INT >= 23){
                timePicker.hour = 20
                timePicker.minute = 15
            }else{
                timePicker.currentHour = 20
                timePicker.currentMinute = 15
            }
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

    override fun onTimeChanged(timePicker: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(this, "$hourOfDay : $minute", Toast.LENGTH_LONG).show()
    }
}

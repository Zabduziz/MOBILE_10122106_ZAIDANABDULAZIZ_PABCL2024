package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner

class SuhuActivity : AppCompatActivity() {
    private lateinit var spSuhuAwal: Spinner
    private lateinit var spSuhuAkhir: Spinner
    private lateinit var btHitungSuhu: Button
    private lateinit var btBackSuhu: ImageButton
    private lateinit var edtSuhuAwal: EditText
    private lateinit var edtSuhuAkhir: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suhu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        spSuhuAwal = findViewById(R.id.sp_suhu_awal)
        spSuhuAkhir = findViewById(R.id.sp_suhu_akhir)
        btHitungSuhu = findViewById(R.id.btHitungSuhu)
        btBackSuhu = findViewById(R.id.bt_suhu_back)
        edtSuhuAwal = findViewById(R.id.et_suhu_awal)
        edtSuhuAkhir = findViewById(R.id.et_suhu_akhir)

        btHitungSuhu.setOnClickListener {
            val suhuAwal = spSuhuAwal.selectedItem
            val suhuAkhir = spSuhuAkhir.selectedItem
            val inputAwal = edtSuhuAwal.text.toString().trim()
            if (inputAwal.isEmpty()) {
                edtSuhuAwal.error = "Mohon Diisi"
            } else {
                when (suhuAwal) {
                    "Kelvin(K)" -> transformKelvin(inputAwal, suhuAkhir)
                    "Celcius(C)" -> transformCelcius(inputAwal, suhuAkhir)
                    "Fahrenheit(F)" -> transformFahrenheit(inputAwal, suhuAkhir)
                    "Reamur(R)" -> transformReamur(inputAwal, suhuAkhir)
                }
            }
        }
        btBackSuhu.setOnClickListener {
            finish()
            val back = Intent(this@SuhuActivity, MainActivity::class.java)
            startActivity(back)
        }

    }
    private fun transformKelvin(awal: String, option: Any) {
        when (option) {
            "Kelvin(K)" -> edtSuhuAkhir.setText(awal)
            "Celcius(C)" -> edtSuhuAkhir.setText((awal.toDouble() - 273.15).toString())
            "Fahrenheit(F)" -> edtSuhuAkhir.setText(((awal.toDouble() - 275.15) * 1.8 + 32).toString())
            "Reamur(R)" -> edtSuhuAkhir.setText(((awal.toDouble() - 273.15) * 0.8).toString())
        }
    }
    private fun transformCelcius(awal: String, option: Any) {
        when (option) {
            "Kelvin(K)" -> edtSuhuAkhir.setText((awal.toDouble() + 273.15).toString())
            "Celcius(C)" -> edtSuhuAkhir.setText(awal)
            "Fahrenheit(F)" -> edtSuhuAkhir.setText(((awal.toDouble() * 1.8) + 32).toString())
            "Reamur(R)" -> edtSuhuAkhir.setText((awal.toDouble() * 0.8).toString())
        }
    }
    private fun transformFahrenheit(awal: String, option: Any) {
        when (option) {
            "Kelvin(K)" -> edtSuhuAkhir.setText(((awal.toDouble() - 32) * 5/9 + 273.15).toString())
            "Celcius(C)" -> edtSuhuAkhir.setText(((awal.toDouble() - 32) * 5/9).toString())
            "Fahrenheit(F)" -> edtSuhuAkhir.setText(awal)
            "Reamur(R)" -> edtSuhuAkhir.setText(((awal.toDouble() - 32) * 4/9).toString())
        }
    }
    private fun transformReamur(awal: String, option: Any) {
        when (option) {
            "Kelvin(K)" -> edtSuhuAkhir.setText(((awal.toDouble() * 5/4) + 273.15).toString())
            "Celcius(C)" -> edtSuhuAkhir.setText((awal.toDouble() * 5/4).toString())
            "Fahrenheit(F)" -> edtSuhuAkhir.setText(((awal.toDouble() * 9/4) + 32).toString())
            "Reamur(R)" -> edtSuhuAkhir.setText(awal)
        }
    }
}
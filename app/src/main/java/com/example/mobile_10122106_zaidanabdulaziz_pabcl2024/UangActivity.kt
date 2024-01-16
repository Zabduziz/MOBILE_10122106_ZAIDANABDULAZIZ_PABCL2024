package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner

class UangActivity : AppCompatActivity() {
    private lateinit var spUangAwal: Spinner
    private lateinit var spUangAkhir: Spinner
    private lateinit var btHitungUang: Button
    private lateinit var btBackUang: ImageButton
    private lateinit var edtUangAwal: EditText
    private lateinit var edtUangAkhir: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        spUangAwal = findViewById(R.id.sp_uang_awal)
        spUangAkhir = findViewById(R.id.sp_uang_akhir)
        btHitungUang = findViewById(R.id.btHitungUang)
        btBackUang = findViewById(R.id.bt_uang_back)
        edtUangAwal = findViewById(R.id.et_uang_awal)
        edtUangAkhir = findViewById(R.id.et_uang_akhir)

        btHitungUang.setOnClickListener {
            val uangAwal = spUangAwal.selectedItem
            val uangAkhir = spUangAkhir.selectedItem
            val inputAwal = edtUangAwal.text.toString().trim()
            if (inputAwal.isEmpty()) {
                edtUangAwal.error = "Mohon Diisi"
            } else {
                when (uangAwal) {
                    "Indonesia(IDR)" -> transformIndonesia(inputAwal, uangAkhir)
                    "United States(USD)" -> transformAmerika(inputAwal, uangAkhir)
                    "Saudi Arabia(SAR)" -> transformSaudi(inputAwal, uangAkhir)
                }
            }
        }
        btBackUang.setOnClickListener {
            finish()
            val back = Intent(this@UangActivity, MainActivity::class.java)
            startActivity(back)
        }
    }
    private fun transformIndonesia(awal: String, option: Any) {
        when (option) {
            "Indonesia(IDR)" -> edtUangAkhir.setText(awal)
            "United States(USD)" -> edtUangAkhir.setText((awal.toDouble()*0.000064).toString())
            "Saudi Arabia(SAR)" -> edtUangAkhir.setText((awal.toDouble()*0.00024).toString())
        }
    }
    private fun transformAmerika(awal: String, option: Any) {
        when (option) {
            "Indonesia(IDR)" -> edtUangAkhir.setText((awal.toDouble()*15514).toString())
            "United States(USD)" -> edtUangAkhir.setText(awal)
            "Saudi Arabia(SAR)" -> edtUangAkhir.setText((awal.toDouble()*3.75).toString())
        }
    }
    private fun transformSaudi(awal: String, option: Any) {
        when (option) {
            "Indonesia(IDR)" -> edtUangAkhir.setText((awal.toDouble()*4136.99).toString())
            "United States(USD)" -> edtUangAkhir.setText((awal.toDouble()*0.27).toString())
            "Saudi Arabia(SAR)" -> edtUangAkhir.setText(awal)
        }
    }
}
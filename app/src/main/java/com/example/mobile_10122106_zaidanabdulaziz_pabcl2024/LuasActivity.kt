package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner

class LuasActivity : AppCompatActivity() {
    private lateinit var spLuasAwal: Spinner
    private lateinit var spLuasAkhir: Spinner
    private lateinit var btHitungLuas: Button
    private lateinit var btBackLuas: ImageButton
    private lateinit var edtLuasAwal: EditText
    private lateinit var edtLuasAkhir: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luas)

        spLuasAwal = findViewById(R.id.sp_luas_awal)
        spLuasAkhir = findViewById(R.id.sp_luas_akhir)
        btHitungLuas = findViewById(R.id.btHitungLuas)
        btBackLuas = findViewById(R.id.bt_luas_back)
        edtLuasAwal = findViewById(R.id.et_luas_awal)
        edtLuasAkhir = findViewById(R.id.et_luas_akhir)

        btHitungLuas.setOnClickListener {
            val luasAwal = spLuasAwal.selectedItem
            val luasAkhir = spLuasAkhir.selectedItem
            val inputAwal = edtLuasAwal.text.toString().trim()
            if (inputAwal.isEmpty()) {
                edtLuasAwal.error = "Mohon Diisi"
            } else {
                when (luasAwal) {
                    "Km\u00B2" -> transformKm2(inputAwal, luasAkhir)
                    "Hm\u00B2" -> transformHm2(inputAwal, luasAkhir)
                    "Dam\u00B2" -> transformDam2(inputAwal, luasAkhir)
                    "M\u00B2" -> transformM2(inputAwal, luasAkhir)
                    "Dm\u00B2" -> transformDm2(inputAwal, luasAkhir)
                    "Cm\u00B2" -> transformCm2(inputAwal, luasAkhir)
                    "mm\u00B2" -> transformMm2(inputAwal, luasAkhir)
                }
            }
        }
        btBackLuas.setOnClickListener {
            finish()
            val back = Intent(this@LuasActivity, MainActivity::class.java)
            startActivity(back)
        }
    }
    private fun transformKm2(awal: String, option: Any) {
        when (option) {
            "Km\u00B2" -> edtLuasAkhir.setText(awal)
            "Hm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100).toString())
            "Dam\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*10000).toString())
            "M\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*1000000).toString())
            "Dm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100000000).toString())
            "Cm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*10000000000).toString())
            "mm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*1000000000000).toString())
        }
    }
    private fun transformHm2(awal: String, option: Any) {
        when (option) {
            "Km\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100).toString())
            "Hm\u00B2" -> edtLuasAkhir.setText(awal)
            "Dam\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100).toString())
            "M\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*10000).toString())
            "Dm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*1000000).toString())
            "Cm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100000000).toString())
            "mm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*10000000000).toString())
        }
    }
    private fun transformDam2(awal: String, option: Any) {
        when (option) {
            "Km\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/10000).toString())
            "Hm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100).toString())
            "Dam\u00B2" -> edtLuasAkhir.setText(awal)
            "M\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100).toString())
            "Dm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*10000).toString())
            "Cm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*1000000).toString())
            "mm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100000000).toString())
        }
    }
    private fun transformM2(awal: String, option: Any) {
        when (option) {
            "Km\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/1000000).toString())
            "Hm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/10000).toString())
            "Dam\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100).toString())
            "M\u00B2" -> edtLuasAkhir.setText(awal)
            "Dm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100).toString())
            "Cm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*10000).toString())
            "mm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*1000000).toString())
        }
    }
    private fun transformDm2(awal: String, option: Any) {
        when (option) {
            "Km\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100000000).toString())
            "Hm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/1000000).toString())
            "Dam\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/10000).toString())
            "M\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100).toString())
            "Dm\u00B2" -> edtLuasAkhir.setText(awal)
            "Cm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100).toString())
            "mm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*10000).toString())
        }
    }
    private fun transformCm2(awal: String, option: Any) {
        when (option) {
            "Km\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/10000000000).toString())
            "Hm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100000000).toString())
            "Dam\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/1000000).toString())
            "M\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/10000).toString())
            "Dm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100).toString())
            "Cm\u00B2" -> edtLuasAkhir.setText(awal)
            "mm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()*100).toString())
        }
    }
    private fun transformMm2(awal: String, option: Any) {
        when (option) {
            "Km\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/1000000000000).toString())
            "Hm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/10000000000).toString())
            "Dam\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100000000).toString())
            "M\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/1000000).toString())
            "Dm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/10000).toString())
            "Cm\u00B2" -> edtLuasAkhir.setText((awal.toDouble()/100).toString())
            "mm\u00B2" -> edtLuasAkhir.setText(awal)
        }
    }
}
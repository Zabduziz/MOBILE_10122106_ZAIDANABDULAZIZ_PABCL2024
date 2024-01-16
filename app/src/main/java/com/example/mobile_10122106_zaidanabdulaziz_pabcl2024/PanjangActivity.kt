package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner

class PanjangActivity : AppCompatActivity() {
    private lateinit var spPanjangAwal: Spinner
    private lateinit var spPanjangAkhir: Spinner
    private lateinit var btHitungPanjang: Button
    private lateinit var btBackPanjang: ImageButton
    private lateinit var edtPanjangAwal: EditText
    private lateinit var edtPanjangAkhir: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panjang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        spPanjangAwal = findViewById(R.id.sp_panjang_awal)
        spPanjangAkhir = findViewById(R.id.sp_panjang_akhir)
        btHitungPanjang = findViewById(R.id.btHitungPanjang)
        btBackPanjang = findViewById(R.id.bt_panjang_back)
        edtPanjangAwal = findViewById(R.id.et_panjang_awal)
        edtPanjangAkhir = findViewById(R.id.et_panjang_akhir)

        btHitungPanjang.setOnClickListener{
            val panjangAwal = spPanjangAwal.selectedItem
            val panjangAkhir = spPanjangAkhir.selectedItem
            val inputAwal = edtPanjangAwal.text.toString().trim()
            if (inputAwal.isEmpty()) {
                edtPanjangAwal.error = "Mohon Diisi"
            } else {
                when (panjangAwal) {
                    "Km" -> transformPanjangKm(inputAwal, panjangAkhir)
                    "Hm" -> transformPanjangHm(inputAwal, panjangAkhir)
                    "Dam" -> transformPanjangDam(inputAwal, panjangAkhir)
                    "M" -> transformPanjangM(inputAwal, panjangAkhir)
                    "Dm" -> transformPanjangDm(inputAwal, panjangAkhir)
                    "Cm" -> transformPanjangCm(inputAwal, panjangAkhir)
                    "mm" -> transformPanjangMm(inputAwal, panjangAkhir)
                }
            }
        }
        btBackPanjang.setOnClickListener {
            finish()
            val back = Intent(this@PanjangActivity, MainActivity::class.java)
            startActivity(back)
        }
    }
    private fun transformPanjangKm(awal: String, option: Any) {
        when (option) {
            "Km" -> edtPanjangAkhir.setText(awal)
            "Hm" -> edtPanjangAkhir.setText((awal.toDouble()*10).toString())
            "Dam" -> edtPanjangAkhir.setText((awal.toDouble()*100).toString())
            "M" -> edtPanjangAkhir.setText((awal.toDouble()*1000).toString())
            "Dm" -> edtPanjangAkhir.setText((awal.toDouble()*10000).toString())
            "Cm" -> edtPanjangAkhir.setText((awal.toDouble()*100000).toString())
            "mm" -> edtPanjangAkhir.setText((awal.toDouble()*1000000).toString())
        }
    }
    private fun transformPanjangHm(awal: String, option: Any) {
        when (option) {
            "Km" -> edtPanjangAkhir.setText((awal.toDouble()/10).toString())
            "Hm" -> edtPanjangAkhir.setText(awal)
            "Dam" -> edtPanjangAkhir.setText((awal.toDouble()*10).toString())
            "M" -> edtPanjangAkhir.setText((awal.toDouble()*100).toString())
            "Dm" -> edtPanjangAkhir.setText((awal.toDouble()*1000).toString())
            "Cm" -> edtPanjangAkhir.setText((awal.toDouble()*10000).toString())
            "mm" -> edtPanjangAkhir.setText((awal.toDouble()*100000).toString())
        }
    }
    private fun transformPanjangDam(awal: String, option: Any) {
        when (option) {
            "Km" -> edtPanjangAkhir.setText((awal.toDouble()/100).toString())
            "Hm" -> edtPanjangAkhir.setText((awal.toDouble()/10).toString())
            "Dam" -> edtPanjangAkhir.setText(awal)
            "M" -> edtPanjangAkhir.setText((awal.toDouble()*10).toString())
            "Dm" -> edtPanjangAkhir.setText((awal.toDouble()*100).toString())
            "Cm" -> edtPanjangAkhir.setText((awal.toDouble()*1000).toString())
            "mm" -> edtPanjangAkhir.setText((awal.toDouble()*10000).toString())
        }
    }
    private fun transformPanjangM(awal: String, option: Any) {
        when (option) {
            "Km" -> edtPanjangAkhir.setText((awal.toDouble()/1000).toString())
            "Hm" -> edtPanjangAkhir.setText((awal.toDouble()/100).toString())
            "Dam" -> edtPanjangAkhir.setText((awal.toDouble()/10).toString())
            "M" -> edtPanjangAkhir.setText(awal)
            "Dm" -> edtPanjangAkhir.setText((awal.toDouble()*10).toString())
            "Cm" -> edtPanjangAkhir.setText((awal.toDouble()*100).toString())
            "mm" -> edtPanjangAkhir.setText((awal.toDouble()*1000).toString())
        }
    }
    private fun transformPanjangDm(awal: String, option: Any) {
        when (option) {
            "Km" -> edtPanjangAkhir.setText((awal.toDouble()/10000).toString())
            "Hm" -> edtPanjangAkhir.setText((awal.toDouble()/1000).toString())
            "Dam" -> edtPanjangAkhir.setText((awal.toDouble()/100).toString())
            "M" -> edtPanjangAkhir.setText((awal.toDouble()/10).toString())
            "Dm" -> edtPanjangAkhir.setText(awal)
            "Cm" -> edtPanjangAkhir.setText((awal.toDouble()*10).toString())
            "mm" -> edtPanjangAkhir.setText((awal.toDouble()*100).toString())
        }
    }
    private fun transformPanjangCm(awal: String, option: Any) {
        when (option) {
            "Km" -> edtPanjangAkhir.setText((awal.toDouble()/100000).toString())
            "Hm" -> edtPanjangAkhir.setText((awal.toDouble()/10000).toString())
            "Dam" -> edtPanjangAkhir.setText((awal.toDouble()/1000).toString())
            "M" -> edtPanjangAkhir.setText((awal.toDouble()/100).toString())
            "Dm" -> edtPanjangAkhir.setText((awal.toDouble()/10).toString())
            "Cm" -> edtPanjangAkhir.setText(awal)
            "mm" -> edtPanjangAkhir.setText((awal.toDouble()*10).toString())
        }
    }
    private fun transformPanjangMm(awal: String, option: Any) {
        when (option) {
            "Km" -> edtPanjangAkhir.setText((awal.toDouble()/1000000).toString())
            "Hm" -> edtPanjangAkhir.setText((awal.toDouble()/100000).toString())
            "Dam" -> edtPanjangAkhir.setText((awal.toDouble()/10000).toString())
            "M" -> edtPanjangAkhir.setText((awal.toDouble()/1000).toString())
            "Dm" -> edtPanjangAkhir.setText((awal.toDouble()/100).toString())
            "Cm" -> edtPanjangAkhir.setText((awal.toDouble()/10).toString())
            "mm" -> edtPanjangAkhir.setText(awal)
        }
    }
}
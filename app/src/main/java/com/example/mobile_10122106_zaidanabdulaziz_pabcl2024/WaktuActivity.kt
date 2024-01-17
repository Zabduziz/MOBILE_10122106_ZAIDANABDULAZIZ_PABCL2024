package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner

class WaktuActivity : AppCompatActivity() {
    private lateinit var spWaktuAwal: Spinner
    private lateinit var spWaktuAkhir: Spinner
    private lateinit var btHitungWaktu: Button
    private lateinit var btBackWaktu: ImageButton
    private lateinit var edtWaktuAwal: EditText
    private lateinit var edtWaktuAkhir: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waktu)

        spWaktuAwal = findViewById(R.id.sp_waktu_awal)
        spWaktuAkhir = findViewById(R.id.sp_waktu_akhir)
        btHitungWaktu = findViewById(R.id.btHitungWaktu)
        btBackWaktu = findViewById(R.id.bt_waktu_back)
        edtWaktuAwal = findViewById(R.id.et_waktu_awal)
        edtWaktuAkhir = findViewById(R.id.et_waktu_akhir)

        btHitungWaktu.setOnClickListener {
            val waktuAwal = spWaktuAwal.selectedItem
            val waktuAkhir = spWaktuAkhir.selectedItem
            val inputAwal = edtWaktuAwal.text.toString().trim()
            if (inputAwal.isEmpty()) {
                edtWaktuAwal.error = "Mohon Diisi"
            } else {
                when (waktuAwal) {
                    "Detik" -> transformDetik(inputAwal, waktuAkhir)
                    "Menit" -> transformMenit(inputAwal, waktuAkhir)
                    "Jam" -> transformJam(inputAwal, waktuAkhir)
                }
            }
        }
        btBackWaktu.setOnClickListener {
            finish()
            val back = Intent(this@WaktuActivity, MainActivity::class.java)
            startActivity(back)
        }
    }
    private fun transformDetik(awal: String, option: Any) {
        when (option) {
            "Detik" -> edtWaktuAkhir.setText(awal)
            "Menit" -> edtWaktuAkhir.setText((awal.toDouble()/60).toString())
            "Jam" -> edtWaktuAkhir.setText((awal.toDouble()/3600).toString())
        }
    }
    private fun transformMenit(awal: String, option: Any) {
        when (option) {
            "Detik" -> edtWaktuAkhir.setText((awal.toDouble()*60).toString())
            "Menit" -> edtWaktuAkhir.setText(awal)
            "Jam" -> edtWaktuAkhir.setText((awal.toDouble()/60).toString())
        }
    }
    private fun transformJam(awal: String, option: Any) {
        when (option) {
            "Detik" -> edtWaktuAkhir.setText((awal.toDouble()*3600).toString())
            "Menit" -> edtWaktuAkhir.setText((awal.toDouble()*60).toString())
            "Jam" -> edtWaktuAkhir.setText(awal)
        }
    }
}
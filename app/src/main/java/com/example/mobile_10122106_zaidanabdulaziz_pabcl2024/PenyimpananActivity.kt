package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner

class PenyimpananActivity : AppCompatActivity() {
    private lateinit var spPenyimpananAwal: Spinner
    private lateinit var spPenyimpananAkhir: Spinner
    private lateinit var btHitungPenyimpanan: Button
    private lateinit var btBackPenyimpanan: ImageButton
    private lateinit var edtPenyimpananAwal: EditText
    private lateinit var edtPenyimpananAkhir: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penyimpanan)

        spPenyimpananAwal = findViewById(R.id.sp_penyimpanan_awal)
        spPenyimpananAkhir = findViewById(R.id.sp_penyimpanan_akhir)
        btHitungPenyimpanan = findViewById(R.id.btHitungPenyimpanan)
        btBackPenyimpanan = findViewById(R.id.bt_penyimpanan_back)
        edtPenyimpananAwal = findViewById(R.id.et_penyimpanan_awal)
        edtPenyimpananAkhir = findViewById(R.id.et_penyimpanan_akhir)

        btHitungPenyimpanan.setOnClickListener{
            val penyimpananAwal = spPenyimpananAwal.selectedItem
            val penyimpananAkhir = spPenyimpananAkhir.selectedItem
            val inputAwal = edtPenyimpananAwal.text.toString().trim()
            if (inputAwal.isEmpty()) {
                edtPenyimpananAwal.error = "Mohon Diisi"
            } else {
                when (penyimpananAwal) {
                    "KB" -> transformKb(inputAwal, penyimpananAkhir)
                    "MB" -> transformMb(inputAwal, penyimpananAkhir)
                    "GB" -> transformGb(inputAwal, penyimpananAkhir)
                }
            }
        }
        btBackPenyimpanan.setOnClickListener {
            finish()
            val back = Intent(this@PenyimpananActivity, MainActivity::class.java)
            startActivity(back)
        }
    }
    private fun transformKb(awal: String, option: Any) {
        when (option) {
            "KB" -> edtPenyimpananAkhir.setText(awal)
            "MB" -> edtPenyimpananAkhir.setText((awal.toDouble()*0.0009765625).toString())
            "GB" -> edtPenyimpananAkhir.setText((awal.toDouble()*9.536743164E-7).toString())
        }
    }
    private fun transformMb(awal: String, option: Any) {
        when (option) {
            "KB" -> edtPenyimpananAkhir.setText((awal.toDouble()*1024).toString())
            "MB" -> edtPenyimpananAkhir.setText(awal)
            "GB" -> edtPenyimpananAkhir.setText((awal.toDouble()*0.0009765625).toString())
        }
    }
    private fun transformGb(awal: String, option: Any) {
        when (option) {
            "KB" -> edtPenyimpananAkhir.setText((awal.toDouble()*1048576).toString())
            "MB" -> edtPenyimpananAkhir.setText((awal.toDouble()*1024).toString())
            "GB" -> edtPenyimpananAkhir.setText(awal)
        }
    }
}
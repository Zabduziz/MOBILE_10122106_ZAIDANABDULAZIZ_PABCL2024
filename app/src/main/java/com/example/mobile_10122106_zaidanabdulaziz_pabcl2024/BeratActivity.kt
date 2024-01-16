package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner

class BeratActivity : AppCompatActivity() {
    private lateinit var spBeratAwal: Spinner
    private lateinit var spBeratAkhir: Spinner
    private lateinit var btHitungBerat: Button
    private lateinit var btBackBerat: ImageButton
    private lateinit var edtBeratAwal: EditText
    private lateinit var edtBeratAkhir: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berat)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        spBeratAwal = findViewById(R.id.sp_berat_awal)
        spBeratAkhir = findViewById(R.id.sp_berat_akhir)
        btHitungBerat = findViewById(R.id.btHitungBerat)
        btBackBerat = findViewById(R.id.bt_berat_back)
        edtBeratAwal = findViewById(R.id.et_berat_awal)
        edtBeratAkhir = findViewById(R.id.et_berat_akhir)

        btHitungBerat.setOnClickListener {
            val beratAwal = spBeratAwal.selectedItem
            val beratAkhir = spBeratAkhir.selectedItem
            val inputAwal = edtBeratAwal.text.toString().trim()
            if (inputAwal.isEmpty()) {
                edtBeratAwal.error = "Mohon Diisi"
            } else {
                when (beratAwal) {
                    "Kg" -> transformBeratKg(inputAwal, beratAkhir)
                    "Hg" -> transformBeratHg(inputAwal, beratAkhir)
                    "Dag" -> transformBeratDag(inputAwal, beratAkhir)
                    "Gr" -> transformBeratGr(inputAwal, beratAkhir)
                    "Dg" -> transformBeratDg(inputAwal, beratAkhir)
                    "Cg" -> transformBeratCg(inputAwal, beratAkhir)
                    "Mg" -> transformBeratMg(inputAwal, beratAkhir)
                }
            }
        }
        btBackBerat.setOnClickListener {
            finish()
            val back = Intent(this@BeratActivity, MainActivity::class.java)
            startActivity(back)
        }
    }
    private fun transformBeratKg(awal: String, option: Any) {
        when (option) {
            "Kg" -> edtBeratAkhir.setText(awal)
            "Hg" -> edtBeratAkhir.setText((awal.toDouble()*10).toString())
            "Dag" -> edtBeratAkhir.setText((awal.toDouble()*100).toString())
            "Gr" -> edtBeratAkhir.setText((awal.toDouble()*1000).toString())
            "Dg" -> edtBeratAkhir.setText((awal.toDouble()*10000).toString())
            "Cg" -> edtBeratAkhir.setText((awal.toDouble()*100000).toString())
            "Mg" -> edtBeratAkhir.setText((awal.toDouble()*1000000).toString())
        }
    }
    private fun transformBeratHg(awal: String, option: Any) {
        when (option) {
            "Kg" -> edtBeratAkhir.setText((awal.toDouble()/10).toString())
            "Hg" -> edtBeratAkhir.setText(awal)
            "Dag" -> edtBeratAkhir.setText((awal.toDouble()*10).toString())
            "Gr" -> edtBeratAkhir.setText((awal.toDouble()*100).toString())
            "Dg" -> edtBeratAkhir.setText((awal.toDouble()*1000).toString())
            "Cg" -> edtBeratAkhir.setText((awal.toDouble()*10000).toString())
            "Mg" -> edtBeratAkhir.setText((awal.toDouble()*100000).toString())
        }
    }
    private fun transformBeratDag(awal: String, option: Any) {
        when (option) {
            "Kg" -> edtBeratAkhir.setText((awal.toDouble()/100).toString())
            "Hg" -> edtBeratAkhir.setText((awal.toDouble()/10).toString())
            "Dag" -> edtBeratAkhir.setText(awal)
            "Gr" -> edtBeratAkhir.setText((awal.toDouble()*10).toString())
            "Dg" -> edtBeratAkhir.setText((awal.toDouble()*100).toString())
            "Cg" -> edtBeratAkhir.setText((awal.toDouble()*1000).toString())
            "Mg" -> edtBeratAkhir.setText((awal.toDouble()*10000).toString())
        }
    }
    private fun transformBeratGr(awal: String, option: Any) {
        when (option) {
            "Kg" -> edtBeratAkhir.setText((awal.toDouble()/1000).toString())
            "Hg" -> edtBeratAkhir.setText((awal.toDouble()/100).toString())
            "Dag" -> edtBeratAkhir.setText((awal.toDouble()/10).toString())
            "Gr" -> edtBeratAkhir.setText(awal)
            "Dg" -> edtBeratAkhir.setText((awal.toDouble()*10).toString())
            "Cg" -> edtBeratAkhir.setText((awal.toDouble()*100).toString())
            "Mg" -> edtBeratAkhir.setText((awal.toDouble()*1000).toString())
        }
    }
    private fun transformBeratDg(awal: String, option: Any) {
        when (option) {
            "Kg" -> edtBeratAkhir.setText((awal.toDouble()/10000).toString())
            "Hg" -> edtBeratAkhir.setText((awal.toDouble()/1000).toString())
            "Dag" -> edtBeratAkhir.setText((awal.toDouble()/100).toString())
            "Gr" -> edtBeratAkhir.setText((awal.toDouble()/10).toString())
            "Dg" -> edtBeratAkhir.setText(awal)
            "Cg" -> edtBeratAkhir.setText((awal.toDouble()*10).toString())
            "Mg" -> edtBeratAkhir.setText((awal.toDouble()*100).toString())
        }
    }
    private fun transformBeratCg(awal: String, option: Any) {
        when (option) {
            "Kg" -> edtBeratAkhir.setText((awal.toDouble()/100000).toString())
            "Hg" -> edtBeratAkhir.setText((awal.toDouble()/10000).toString())
            "Dag" -> edtBeratAkhir.setText((awal.toDouble()/1000).toString())
            "Gr" -> edtBeratAkhir.setText((awal.toDouble()/100).toString())
            "Dg" -> edtBeratAkhir.setText((awal.toDouble()/10).toString())
            "Cg" -> edtBeratAkhir.setText(awal)
            "Mg" -> edtBeratAkhir.setText((awal.toDouble()*10).toString())
        }
    }
    private fun transformBeratMg(awal: String, option: Any) {
        when (option) {
            "Kg" -> edtBeratAkhir.setText((awal.toDouble()/1000000).toString())
            "Hg" -> edtBeratAkhir.setText((awal.toDouble()/100000).toString())
            "Dag" -> edtBeratAkhir.setText((awal.toDouble()/10000).toString())
            "Gr" -> edtBeratAkhir.setText((awal.toDouble()/1000).toString())
            "Dg" -> edtBeratAkhir.setText((awal.toDouble()/100).toString())
            "Cg" -> edtBeratAkhir.setText((awal.toDouble()/10).toString())
            "Mg" -> edtBeratAkhir.setText(awal)
        }
    }
}
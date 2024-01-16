package com.example.mobile_10122106_zaidanabdulaziz_pabcl2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val suhu: CardView = findViewById(R.id.cv1)
        val mataUang: CardView = findViewById(R.id.cv2)
        val berat: CardView = findViewById(R.id.cv3)
        val panjang: CardView = findViewById(R.id.cv4)
        val penyimpanan: CardView = findViewById(R.id.cv5)
        val waktu: CardView = findViewById(R.id.cv6)
        val luas: CardView = findViewById(R.id.cv7)

        suhu.setOnClickListener {
            val moveIntentSuhu = Intent(this@MainActivity, SuhuActivity::class.java)
            startActivity(moveIntentSuhu)
        }
        mataUang.setOnClickListener {
            val moveIntentUang = Intent(this@MainActivity, UangActivity::class.java)
            startActivity(moveIntentUang)
        }
        berat.setOnClickListener {
            val moveIntentBerat = Intent(this@MainActivity, BeratActivity::class.java)
            startActivity(moveIntentBerat)
        }
        panjang.setOnClickListener {
            val moveIntentPanjang = Intent(this@MainActivity, PanjangActivity::class.java)
            startActivity(moveIntentPanjang)
        }
        penyimpanan.setOnClickListener {
            val moveIntentPenyimpanan = Intent(this@MainActivity, PenyimpananActivity::class.java)
            startActivity(moveIntentPenyimpanan)
        }
        waktu.setOnClickListener {
            val moveIntentWaktu = Intent(this@MainActivity, WaktuActivity::class.java)
            startActivity(moveIntentWaktu)
        }
        luas.setOnClickListener {
            val moveIntenLuas = Intent(this@MainActivity, LuasActivity::class.java)
            startActivity(moveIntenLuas)
        }
    }
}
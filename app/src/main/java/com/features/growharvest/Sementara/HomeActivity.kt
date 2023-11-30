package com.features.growharvest.Sementara

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.features.growharvest.R
import com.features.growharvest.TransaksiSementara.KeranjangSementaraActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var btnTransaksi: ImageButton
    private lateinit var btnAccount: ImageButton
    private lateinit var btnProduct: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        btnAccount = findViewById(R.id.btnAccount)
        btnTransaksi = findViewById(R.id.btnTransaksi)
        btnProduct = findViewById(R.id.btnProduct)

        btnAccount.setOnClickListener{
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }

        btnProduct.setOnClickListener{
            val intent = Intent(this, DataProductActivity::class.java)
            startActivity(intent)
        }

        btnTransaksi.setOnClickListener {
            val intent = Intent(this, KeranjangSementaraActivity::class.java)
            startActivity(intent)
        }
    }
}

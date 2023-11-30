package com.features.growharvest.Sementara

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.features.growharvest.R

class AccountActivity : AppCompatActivity() {
    private lateinit var btnLogOut: ImageButton
    private lateinit var txtUsername: TextView
    private lateinit var imageUser: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_akun)

        btnLogOut = findViewById(R.id.imgbtnLogout)
        txtUsername = findViewById(R.id.txtUsername)
        imageUser = findViewById(R.id.userImage)

        btnLogOut.setOnClickListener{
            // Handle logout logic here if needed
            // For now, let's just finish the activity
            finish()
        }
    }
}

package com.features.growharvest.LoginActivity
// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.features.growharvest.NavigationBar.NavbarMainActivity
import com.features.growharvest.R
import com.features.growharvest.Sementara.HomeActivity

class LoginBiasaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUsername = findViewById<EditText>(R.id.txt_login_username)
        val editTextPassword = findViewById<EditText>(R.id.txt_login_password)
        val buttonLogin = findViewById<ImageButton>(R.id.btnLogin)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (isValidLogin(username, password)) {
                // Login berhasil, tambahkan logika atau navigasi ke aktivitas selanjutnya
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                navigateToNextPage()
            } else {
                // Login gagal, tampilkan pesan kesalahan
                Toast.makeText(this, "Login gagal, cek username dan password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        // Ganti dengan username dan password yang diinginkan
        val validUsers = mapOf(
            "admin" to "admin",
            "fatur" to "123",
            "gandi" to "123",
            "tegar" to "123"
            // Tambahkan username dan password lainnya sesuai kebutuhan
        )

        return validUsers[username] == password
    }
    private fun navigateToNextPage() {
        // Intent untuk navigasi ke halaman berikutnya
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // Menutup MainActivity agar tidak dapat kembali ke halaman login
    }
}

package com.example.futurate.UI.Login.reigster

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.futurate.R
import com.example.futurate.RegisterApi.RegisterRequest
import com.example.futurate.RegisterApi.ResponseRegister
import com.example.futurate.RegisterApi.Retrofit.ApiService
import com.example.futurate.UI.MainActivity
import com.example.futurate.sessionUid.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etUname: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi UI
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etUname = findViewById(R.id.etUsername)
        btnRegister = findViewById(R.id.btnRegister)

        // Klik tombol register
        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val uname = etUname.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || uname.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                registerUser(name, email, password, uname)
            }
        }
    }

    private fun registerUser(name: String, email: String, password: String, uname: String) {
        val apiService = ApiService.create()
        val registerRequest = RegisterRequest(name, email, password, uname)

        apiService.register(registerRequest).enqueue(object : Callback<ResponseRegister> {
            override fun onResponse(call: Call<ResponseRegister>, response: Response<ResponseRegister>) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null && registerResponse.message == "User registered successfully") {
                        Toast.makeText(this@RegisterActivity, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                        // Pindah ke MainActivity
                        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                        intent.putExtra("UID", registerResponse.uid) // Kirim UID ke MainActivity
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@RegisterActivity, "Registrasi gagal: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@RegisterActivity, "Registrasi gagal: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
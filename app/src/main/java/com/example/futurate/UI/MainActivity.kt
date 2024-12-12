package com.example.futurate.UI

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.futurate.R
import com.example.futurate.UI.Profile.Profile
import com.example.futurate.data.Repository.UserRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        @Inject lateinit var userRepository: UserRepository

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Sekarang userRepository bisa digunakan di sini
        }

            // Menangani klik pada tombol profil
            val profileButton: ImageButton = findViewById(R.id.)
            profileButton.setOnClickListener {
                // Menampilkan ProfileFragment
                val profileFragment = Profile()

                // Menggunakan FragmentTransaction untuk mengganti fragment
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, profileFragment) // R.id.fragment_container adalah ID container fragment
                transaction.addToBackStack(null) // Menambahkan fragment ke back stack
                transaction.commit()
            }
        }
    }
}
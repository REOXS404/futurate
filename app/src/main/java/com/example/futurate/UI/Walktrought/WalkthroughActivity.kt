package com.example.futurate.UI.Walktrought

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.futurate.R
import com.example.futurate.UI.Login.LoginActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class WalkthroughActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        buttonNext = findViewById(R.id.btnNext)

        val fragments = listOf(
            WalkthroughFragment.newInstance(R.drawable.wk_1, "Welcome", "This is a great app!"),
            WalkthroughFragment.newInstance(R.drawable.wk_2, "Futurate", "Explore amazing features."),
            WalkthroughFragment.newInstance(R.drawable.wk_3, "Get Started", "Ready to begin?")
        )

        val adapter = WalkthroughAdapter(this, fragments)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        buttonNext.setOnClickListener {
            if (viewPager.currentItem < fragments.size - 1) {
                viewPager.currentItem += 1
            } else {
                // After walkthrough, navigate to LoginActivity
                startActivity(Intent(this, LoginActivity::class.java))
                finish() // Close WalkthroughActivity
            }
        }
    }
}

package com.example.futurate.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.futurate.R
import java.util.logging.Handler

class SplashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Navigate to the appropriate fragment after delay
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val destination = if (onBoardingFinished()) {
                R.id.action_splashFragment_to_homeFragment
            } else {
                R.id.action_splashFragment_to_viewPagerFragment
            }
            findNavController().navigate(destination)
        }, 3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}

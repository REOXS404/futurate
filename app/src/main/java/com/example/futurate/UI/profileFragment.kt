package com.example.futurate.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.futurate.databinding.FragmentProfileBinding
import com.google.android.gms.cast.framework.SessionManager

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Use view binding instead of findViewById
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SessionManager
        sessionManager = com.example.futurate.sessionUid.SessionManager(requireContext())

        // Setup toolbar
        setupToolbar()

        // Populate profile information
        populateProfileInfo()
    }

    private fun setupToolbar() {
        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Profile" // Optional: set toolbar title
        }

        binding.toolbar.setNavigationOnClickListener {
            activity.onBackPressed()
        }
    }

    private fun populateProfileInfo() {
        // Ambil UID dari SharedPreferences
        val uid = sessionManager.getUid()

        // Set UID
        binding.tvUid.text = uid ?: "UID not available"

        // Set profile information
        // In a real app, you'd typically fetch this from a ViewModel or Repository
        binding.apply {
            profileName.text = "John Doe"
            profileSkill.text = "Android Development, Kotlin"
            profileMajor.text = "Computer Science"
            profileUniversity.text = "University of Technology"
            profileHobby.text = "Coding, Reading, Playing Guitar"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding to avoid memory leaks
        _binding = null
    }
}
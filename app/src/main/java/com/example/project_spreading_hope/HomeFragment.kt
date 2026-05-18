package com.example.project_spreading_hope

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class HomeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // 1. Initialize the Views
        val profileSection = view.findViewById<LinearLayout>(R.id.layoutProfile)
        val donateCard = view.findViewById<CardView>(R.id.cardDonate)
        val mediaCard = view.findViewById<CardView>(R.id.cardMedia)

        // 2. Set Click Listeners
        profileSection.setOnClickListener {
            replaceFragment(ProfileFragment())
        }

        donateCard.setOnClickListener {
            replaceFragment(DonateFragment())
        }

        mediaCard.setOnClickListener {
            replaceFragment(MediaFragment())
        }

        return view
    }

    // Helper function to switch fragments
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Use the ID of the container in your Activity (usually R.id.frame_layout or fragment_container)
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
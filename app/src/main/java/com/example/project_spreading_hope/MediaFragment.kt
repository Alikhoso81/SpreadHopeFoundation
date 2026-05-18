package com.example.project_spreading_hope

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class MediaFragment : Fragment() {

    private lateinit var tabAll: TextView
    private lateinit var tabPhotos: LinearLayout
    private lateinit var tabVideos: LinearLayout
    private lateinit var tabs: List<View>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_media, container, false)

        // 1. Initialize Tabs
        tabAll = view.findViewById(R.id.tabAll)
        tabPhotos = view.findViewById(R.id.tabPhotos)
        tabVideos = view.findViewById(R.id.tabVideos)
        tabs = listOf(tabAll, tabPhotos, tabVideos)

        // 2. Tab Click Listeners
        tabAll.setOnClickListener { updateTabUI(tabAll) }
        tabPhotos.setOnClickListener { updateTabUI(tabPhotos) }
        tabVideos.setOnClickListener { updateTabUI(tabVideos) }

        // 3. Initialize Media Cards for Zoom (Add IDs to your XML cards)
        setupZoomForCard(view.findViewById(R.id.cardMedia1), R.drawable.fooddrive)
        setupZoomForCard(view.findViewById(R.id.cardMedia2), R.drawable.media2)
        // Add more cards here as needed

        return view
    }

    private fun setupZoomForCard(card: CardView?, imageResId: Int) {
        card?.setOnClickListener {
            showZoomDialog(imageResId)
        }
    }

    private fun showZoomDialog(imageResId: Int) {
        val dialog = Dialog(requireContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_zoom_image)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val ivZoomed: ImageView = dialog.findViewById(R.id.ivZoomedImage)
        val btnClose: ImageButton = dialog.findViewById(R.id.btnCloseZoom)

        ivZoomed.setImageResource(imageResId)
        btnClose.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

    private fun updateTabUI(selectedTab: View) {
        tabs.forEach { tab ->
            tab.setBackgroundResource(R.drawable.bg_tab_unselected)
            val text = if (tab is TextView) tab else tab.findViewById<TextView>(android.R.id.text1) // Just an example
            // Simplifying text color update for logic
        }
        selectedTab.setBackgroundResource(R.drawable.bg_tab_selected)
    }
}
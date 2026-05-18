package com.example.project_spreading_hope

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProfileFragment : Fragment() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvInitials: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Bind Views
        tvName = view.findViewById(R.id.tvName)
        tvEmail = view.findViewById(R.id.tvProfileEmail)
        tvPhone = view.findViewById(R.id.tvProfilePhone)
        tvInitials = view.findViewById(R.id.tvAvatarInitials)

        // Actions
        view.findViewById<TextView>(R.id.btnEditProfileAction).setOnClickListener { showEditDialog() }
        view.findViewById<TextView>(R.id.btnMyDonationsAction).setOnClickListener { showHistorySheet() }
        view.findViewById<TextView>(R.id.btnLogoutAction).setOnClickListener { showLogoutDialog() }

        return view
    }

    private fun showEditDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_edit_profile)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val etName = dialog.findViewById<EditText>(R.id.etEditName)
        val etEmail = dialog.findViewById<EditText>(R.id.etEditEmail)
        val etPhone = dialog.findViewById<EditText>(R.id.etEditPhone)

        etName.setText(tvName.text)
        etEmail.setText(tvEmail.text)
        etPhone.setText(tvPhone.text)

        dialog.findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            tvName.text = etName.text.toString()
            tvEmail.text = etEmail.text.toString()
            tvPhone.text = etPhone.text.toString()

            val names = etName.text.toString().split(" ")
            tvInitials.text = if(names.size > 1) "${names[0][0]}${names[1][0]}".uppercase() else names[0].take(1).uppercase()

            Toast.makeText(context, "Update Successful! ✅", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showHistorySheet() {
        val sheet = BottomSheetDialog(requireContext())
        // This line looks for res/layout/layout_history_bottom_sheet.xml
        val sheetView = layoutInflater.inflate(R.layout.layout_history_bottom_sheet, null)

        val btnClose = sheetView.findViewById<Button>(R.id.btnCloseSheet)
        btnClose.setOnClickListener { sheet.dismiss() }

        sheet.setContentView(sheetView)
        sheet.show()
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Logout")
            .setMessage("Confirm logout?")
            .setPositiveButton("Yes") { _, _ -> activity?.finish() }
            .setNegativeButton("No", null)
            .show()
    }
}
package com.example.project_spreading_hope

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DonateFragment : Fragment() {

    // 1. Declare variables
    private lateinit var etCustomAmount: EditText
    private lateinit var btnFinalDonate: Button
    private lateinit var tvAmount1000: TextView
    private lateinit var tvAmount10000: TextView
    private lateinit var tvAmount20000: TextView
    private lateinit var tvAmount50000: TextView
    private lateinit var btnPayCard: LinearLayout
    private lateinit var btnPayWallet: LinearLayout
    private lateinit var btnPayUPI: LinearLayout

    private var selectedAmount: String = "1000"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_donate, container, false)

        // 2. Link variables to XML IDs (Verified with your XML code)
        etCustomAmount = view.findViewById(R.id.etCustomAmount)
        btnFinalDonate = view.findViewById(R.id.btnFinalDonate)

        tvAmount1000 = view.findViewById(R.id.tvAmount1000)
        tvAmount10000 = view.findViewById(R.id.tvAmount10000)
        tvAmount20000 = view.findViewById(R.id.tvAmount20000)
        tvAmount50000 = view.findViewById(R.id.tvAmount50000)

        btnPayCard = view.findViewById(R.id.btnPayCard)
        btnPayWallet = view.findViewById(R.id.btnPayWallet)
        btnPayUPI = view.findViewById(R.id.btnPayUPI)

        // 3. Amount Selection Logic
        val amountButtons = listOf(tvAmount1000, tvAmount10000, tvAmount20000, tvAmount50000)

        amountButtons.forEach { textView ->
            textView.setOnClickListener {
                etCustomAmount.text.clear()
                selectedAmount = textView.text.toString()

                // Update UI Colors
                amountButtons.forEach {
                    it.setBackgroundResource(R.drawable.btn_outline_grey)
                    it.setTextColor(Color.parseColor("#424242"))
                }
                textView.setBackgroundResource(R.drawable.btn_outline_selected)
                textView.setTextColor(Color.parseColor("#E91E63"))

                btnFinalDonate.text = "Donate Rs. $selectedAmount"
            }
        }

        // 4. Custom Amount Watcher
        etCustomAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()) {
                    amountButtons.forEach {
                        it.setBackgroundResource(R.drawable.btn_outline_grey)
                        it.setTextColor(Color.parseColor("#424242"))
                    }
                    btnFinalDonate.text = "Donate Rs. $s"
                } else {
                    btnFinalDonate.text = "Donate Rs. $selectedAmount"
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // 5. Payment Selection Logic
        val paymentButtons = listOf(btnPayCard, btnPayWallet, btnPayUPI)
        paymentButtons.forEach { layout ->
            layout.setOnClickListener {
                paymentButtons.forEach { it.setBackgroundResource(R.drawable.btn_outline_grey) }
                layout.setBackgroundResource(R.drawable.btn_outline_selected)
            }
        }

        // 6. Final Click
        btnFinalDonate.setOnClickListener {
            val amountToDisplay = if (etCustomAmount.text.isNotEmpty())
                etCustomAmount.text.toString() else selectedAmount

            showSuccessDialog(amountToDisplay)
        }

        return view
    }

    private fun showSuccessDialog(amount: String) {
        val dialog = Dialog(requireContext())
        val dialogView = layoutInflater.inflate(R.layout.dialog_success, null)
        dialog.setContentView(dialogView)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMsg = dialogView.findViewById<TextView>(R.id.tvSuccessMessage)
        val btnDone = dialogView.findViewById<Button>(R.id.btnDone)

        tvMsg.text = "Your donation of Rs. $amount was successful. Thank you for spreading hope!"

        btnDone.setOnClickListener {
            dialog.dismiss()

            // Switch to Home Fragment
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.frame_layout, HomeFragment())
                .commit()

            // Reset Bottom Navigation highlight to Home icon
            val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNav?.selectedItemId = R.id.Home
        }

        dialog.show()
    }
}
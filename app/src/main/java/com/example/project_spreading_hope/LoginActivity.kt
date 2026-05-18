package com.example.project_spreading_hope

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val email = findViewById<EditText>(R.id.edtEmail)
        val password = findViewById<EditText>(R.id.edtPassword)
        val loginBtn = findViewById<Button>(R.id.btnLogin)
        val goToSignupBtn = findViewById<Button>(R.id.btnGoToSignup)

        // Go to Signup Activity
        goToSignupBtn.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        // Login Logic
        loginBtn.setOnClickListener {
            val emailText = email.text.toString()
            val passText = password.text.toString()

            if (emailText.isNotEmpty() && passText.isNotEmpty()) {
                auth.signInWithEmailAndPassword(emailText, passText)
                    .addOnSuccessListener {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }.addOnFailureListener {
                        Toast.makeText(this, "Login Failed: ${it.message}", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
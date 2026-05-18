package com.example.project_spreading_hope

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_acitivity)

        auth = FirebaseAuth.getInstance()

        val name = findViewById<android.widget.EditText>(R.id.edtName)
        val email = findViewById<android.widget.EditText>(R.id.edtEmail)
        val password = findViewById<android.widget.EditText>(R.id.edtPassword)
        val signupBtn = findViewById<android.widget.Button>(R.id.btnSignup)
        val loginText = findViewById<android.widget.TextView>(R.id.txtLogin)

        // Go to Login
        loginText.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Signup + Save to Firebase
        signupBtn.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                email.text.toString(),
                password.text.toString()
            ).addOnSuccessListener {

                val userId = auth.currentUser!!.uid
                val userData = mapOf(
                    "name" to name.text.toString(),
                    "email" to email.text.toString()
                )

                FirebaseDatabase.getInstance()
                    .getReference("Users")
                    .child(userId)
                    .setValue(userData)

                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()

            }.addOnFailureListener {
                Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

package com.example.evtapsirigi10

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        val loginBtn: Button = findViewById(R.id.btnLogin)
        val editTxtEmail: TextInputEditText = findViewById(R.id.editTxtEmail)
        val editTxtPassword: TextInputEditText = findViewById(R.id.editTxtPassword)

        val txtLoginToRegister: TextView = findViewById(R.id.txtLoginToRegister)
        val sharedPreference=getSharedPreferences("user_info",MODE_PRIVATE)


        loginBtn.setOnClickListener {
            val savedEmail = sharedPreference.getString("email","")
            val savedPassword = sharedPreference.getString("password","")
            val email: String = editTxtEmail.text.toString()
            val password: String = editTxtPassword.text.toString()


            /* if (email.isEmpty()) {
                 showMessage("email is empty")
             } else if (password == "123" && email == "test@") {
                 showMessage("Success")
             } else {
                 showMessage("ERROR - invalid user name or password", Toast.LENGTH_SHORT)
             }*/

            when {
                email.isEmpty() -> showMessage("Email boş ola bilməz")
                email == savedEmail && password == savedPassword -> {
                    showMessage("Uğurlu giriş!")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else -> showMessage(
                    "Xəta: İstifadəçi adı və ya şifrə yanlışdır",
                    Toast.LENGTH_SHORT
                )
            }
            loginBtn.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        txtLoginToRegister.setOnClickListener {
            /**
             * Intent: Ekranlar arası "Bilet"
             * 'this' (haradayıq) -> 'RegisterScreen::class.java' (haraya gedirik)
             */
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    fun showMessage(message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()

    }



}
package com.example.evtapsirigi10
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val txtRegisterToLogin: TextView = findViewById(R.id.txtRegisterToLogin)

        val editTxtEmail: TextInputEditText = findViewById(R.id.editTxtEmail)
        val editTxtPassword: TextInputEditText = findViewById(R.id.editTxtPassword)
        val editTxtConfirmPassword: TextInputEditText = findViewById(R.id.editTxtConPassword)
        val editTxtFullName: TextInputEditText = findViewById(R.id.editTxtFullName)

        val sharedPreferences = getSharedPreferences("user_info",MODE_PRIVATE)
        val shared = sharedPreferences.edit()

        btnRegister.setOnClickListener {
            val email: String = editTxtEmail.text.toString()
            val password: String = editTxtPassword.text.toString()
            val cPassword: String = editTxtConfirmPassword.text.toString()
            val fullname: String = editTxtFullName.text.toString()
            if (
                fullname.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty() ||
                cPassword.isEmpty()
            ) {
                Toast.makeText(this, "Bütün xanaları doldurun!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener


            }
            if (password != cPassword) {
                Toast.makeText(this, "Şifrələr uyğun gəlmir!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            else {
                Toast.makeText(this, "Qeydiyyat uğurludur!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)


            }

            shared.putString("email",email).apply()
            shared.putString("password",password).apply()
            shared.putString("cPassword",cPassword).apply()
            shared.putString("fullname",fullname).apply()

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)






        }

        txtRegisterToLogin.setOnClickListener {
            /* KÖHNƏ ÜSUL: val intent = Intent(this, LoginScreen::class.java)
               BU NİYƏ PİS İDİ? Çünki hər dəfə yeni bir LoginScreen açırdı və yaddaşı doldururdu.
               Əgər sən Register ekranında yenidən startActivity(Intent(this, LoginScreen::class.java)) yazsan:

               Nə baş verir? Sistem masanın üstünə YENİ BİR Login kağızı qoyur.

               Stack belə görünür: Login (1) -> Register -> Login (2).

               Problem: İstifadəçi telefonun "Geri" düyməsini basanda o, 2-ci Login-dən çıxıb təzədən Register-ə qayıdacaq!
               Bu isə istifadəçini dəli edər. Üstəlik, hər yeni startActivity yaddaşda (RAM) əlavə yer tutur.
            */

            // YENİ ÜSUL: Sadəcə bu səhifəni bağla.

            btnRegister.setOnClickListener {


            }

            finish()
        }
    }
}
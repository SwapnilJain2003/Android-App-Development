package com.swapnil.module3assignment

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var etMobileNumber: EditText
    lateinit var etEmail: EditText
    lateinit var btnNext: Button
    val validMobileNumber = "0123456789"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("User Preferences", MODE_PRIVATE)
        setContentView(R.layout.activity_forgot_password)

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etEmail = findViewById(R.id.etEmail)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val email = etEmail.text.toString()
            val bundle = Bundle()
            bundle.putString("data","forgot")
            if(mobileNumber == validMobileNumber)
            {
                savePreferences(mobileNumber,email)
                val intent = Intent(this@ForgotPasswordActivity,BlankActivity::class.java)

                bundle.putString("mobileNumber",mobileNumber)
                bundle.putString("email",email)
                intent.putExtra("details",bundle)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@ForgotPasswordActivity,"Invalid Mobile Number!",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    private fun savePreferences(mobileNumber: String?, email: String?){
        sharedPreferences.edit().putString("Mobile Number",mobileNumber).apply()
        sharedPreferences.edit().putString("Email",email).apply()
    }
}
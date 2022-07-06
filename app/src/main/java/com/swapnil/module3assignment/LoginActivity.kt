package com.swapnil.module3assignment

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNmber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtSignUp: TextView

    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("byebye","hello","iamnoob","internshala","pro","etc")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("User Preferences", MODE_PRIVATE)
        val isLoggedIn =sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if(isLoggedIn)
        {
            val buttonIntent = Intent(this@LoginActivity,BlankActivity::class.java)
            startActivity(buttonIntent)
            finish()
        }

        etMobileNmber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtSignUp = findViewById(R.id.txtSignUp)

        btnLogin.setOnClickListener {
            val mobileNumber =etMobileNmber.text.toString()
            val password = etPassword.text.toString()
            val nameOfUser: String
            val buttonIntent = Intent(this@LoginActivity,BlankActivity::class.java)
            val bundle = Bundle()
            bundle.putString("data","login")

            if(mobileNumber == validMobileNumber) {
                when(password) {
                    validPassword[0] -> {
                        nameOfUser = "User1"
                        bundle.putString("mobile",validMobileNumber)
                        bundle.putString("password",password)
                        bundle.putString("nameOfUser",nameOfUser)
                        buttonIntent.putExtra("details",bundle)
                        savePreferences(nameOfUser,mobileNumber,password)
                        startActivity(buttonIntent)
                    }
                    validPassword[1] -> {
                        nameOfUser = "User2"
                        bundle.putString("mobile",validMobileNumber)
                        bundle.putString("password",password)
                        bundle.putString("nameOfUser",nameOfUser)
                        buttonIntent.putExtra("details",bundle)
                        savePreferences(nameOfUser,mobileNumber,password)
                        startActivity(buttonIntent)
                    }
                    validPassword[2] -> {
                        nameOfUser = "Admin1"
                        bundle.putString("mobile",validMobileNumber)
                        bundle.putString("password",password)
                        bundle.putString("nameOfUser",nameOfUser)
                        buttonIntent.putExtra("details",bundle)
                        savePreferences(nameOfUser,mobileNumber,password)
                        startActivity(buttonIntent)
                    }
                    validPassword[3] -> {
                        nameOfUser = "User3"
                        bundle.putString("mobile",validMobileNumber)
                        bundle.putString("password",password)
                        bundle.putString("nameOfUser",nameOfUser)
                        buttonIntent.putExtra("details",bundle)
                        savePreferences(nameOfUser,mobileNumber,password)
                        startActivity(buttonIntent)
                    }
                    validPassword[4] -> {
                        nameOfUser = "Admin2"
                        bundle.putString("mobile",validMobileNumber)
                        bundle.putString("password",password)
                        bundle.putString("nameOfUser",nameOfUser)
                        buttonIntent.putExtra("details",bundle)
                        savePreferences(nameOfUser,mobileNumber,password)
                        startActivity(buttonIntent)
                    }
                    validPassword[5] -> {
                        nameOfUser = "User4"
                        bundle.putString("mobile",validMobileNumber)
                        bundle.putString("password",password)
                        bundle.putString("nameOfUser",nameOfUser)
                        buttonIntent.putExtra("details",bundle)
                        savePreferences(nameOfUser,mobileNumber,password)
                        startActivity(buttonIntent)
                    }
                    else -> Toast.makeText(this@LoginActivity,"Incorrect Password!",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@LoginActivity,"Incorrect Credentials!",Toast.LENGTH_SHORT).show()
            }
        }
        txtForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
        txtSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    private fun savePreferences(userName: String?, mobileNumber: String?, password: String?){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",userName).apply()
        sharedPreferences.edit().putString("Title",mobileNumber).apply()
        sharedPreferences.edit().putString("Title",password).apply()
    }
}
package com.swapnil.module3assignment

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {
    lateinit var imgPrev: ImageView
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etMobileNumber: EditText
    lateinit var etDeliveryAddress: EditText
    lateinit var etPassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imgPrev = findViewById(R.id.imgPrev)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etDeliveryAddress = findViewById(R.id.etDeliveryAddress)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)



        val bundle =  Bundle()
        bundle.putString("data","register")
        val intent = Intent(this@RegisterActivity,BlankActivity::class.java)

        imgPrev.setOnClickListener {
            val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val mobileNumber = etMobileNumber.text.toString()
            val deliveryAddress = etDeliveryAddress.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if(password==confirmPassword)
            {
                bundle.putString("Name", name)
                bundle.putString("Email",email)
                bundle.putString("mobileNumber",mobileNumber)
                bundle.putString("deliveryAddress",deliveryAddress)
                bundle.putString("password",password)
                bundle.putString("confirmPassword",confirmPassword)
                intent.putExtra("details",bundle)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@RegisterActivity,"Passwords do not match!",Toast.LENGTH_SHORT).show()
            }
        }


    }
}

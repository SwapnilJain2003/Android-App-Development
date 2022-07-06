package com.swapnil.module3assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BlankActivity : AppCompatActivity() {

    lateinit var txtData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank)

        txtData = findViewById(R.id.txtData)

        if(intent!=null)
        {
            val details =intent.getBundleExtra("details")

            val data = details?.getString("data")
            if(data=="login")
            {
                val text ="Mobile Number : ${details.getString("mobile")} \n" +
                        "Password: ${details.getString("password")} \n" +
                        "User Name: ${details?.getString("nameOfUser")}"
                txtData.text = text
            }
            if(data=="forgot")
            {
                val text ="Mobile Number : ${details.getString("mobileNumber")} \n" +
                        "Email: ${details.getString("email")} \n"
                txtData.text = text
            }
            if(data=="register")
            {
                val text = "Name : ${details.getString("Name")} \n" +
                        "Email: ${details.getString("Email")} \n" +
                        "Mobile Number: ${details.getString("mobileNumber")} \n" +
                        "Delivery Address: ${details.getString("deliveryAddress")} \n" +
                        "Password : ${details.getString("password")} \n"
                txtData.text = text
            }
            if(data==null)
            {
                val text = "No data Rececived!!"
                txtData.text = text
            }
        }
    }
}
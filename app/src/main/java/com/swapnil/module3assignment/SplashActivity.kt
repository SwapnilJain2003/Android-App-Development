package com.swapnil.module3assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    lateinit var imgFoodAppLogo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imgFoodAppLogo = findViewById(R.id.imgFoodAppLogo)
        Handler().postDelayed({
            val startAct = Intent(this@SplashActivity,LoginActivity::class.java)
            startActivity(startAct)
        },2000)

        imgFoodAppLogo.setOnClickListener {
            val intent =  Intent(this@SplashActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
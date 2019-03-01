package com.clakestudio.pc.dzisja.util

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clakestudio.pc.dzisja.MainActivity
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.util.SharedPreferencesProvider.get

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefs = SharedPreferencesProvider.getDefaultSharedPreferences(this)
        if(prefs[getString(R.string.is_first_time), false]!!) {
            // startActivity(Intent(this, InfoActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }
}

package com.rsschool.quiz

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rsschool.quiz.utility.APP_ACTIVITY
import com.rsschool.quiz.utility.AppPreference


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        AppPreference.getPreference(this)
    }

    fun updateStatusBarColor(color: String?) { // Color must be in hexadecimal format
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor(color)
    }

}
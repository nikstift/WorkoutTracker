package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class History: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.workout -> {
                    val intent = Intent(this@History, DetailActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.history -> {
                    // Hier starten Sie die HistoryActivity
                    true
                }
                else -> false
            }
        }
    }
}
package com.example.workouttracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private val logTag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pushButton = findViewById<Button>(R.id.workoutPush)
        val pullButton = findViewById<Button>(R.id.workoutPull)
        val legButton = findViewById<Button>(R.id.workoutLeg)
        val individualButton = findViewById<Button>(R.id.workoutIndividual)

        pushButton.setOnClickListener {
            val intent = Intent(this, PushActivity::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, "Push Workout")
            startActivity(intent)
        }

        pullButton.setOnClickListener {
            val intent = Intent(this, PullActivity::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, "Pull Workout")
            startActivity(intent)
        }

        legButton.setOnClickListener {
            val intent = Intent(this, LegActivity::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, "Leg Workout")
            startActivity(intent)
        }

        individualButton.setOnClickListener {
            val intent = Intent(this, IndividualActivity::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, "Flex Workout")
            startActivity(intent)
        }
    }




    override fun onStart() {
        super.onStart()
        Log.e(logTag, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.e(logTag, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.e(logTag, "onPause called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(logTag, "onDestroy called")
    }
}


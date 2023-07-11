package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class IndividualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)
        val workoutName = findViewById<TextView>(R.id.workoutName)
        workoutName.text = intent.getStringExtra(Intent.EXTRA_TEXT)

        val recyclerView = findViewById<RecyclerView>(R.id.rvExercises)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = ExerciseListAdapter(createIndividualExercises())
        val divider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(divider)

    }
}

fun createIndividualExercises():List<Exercise>{
    val exerciseList = mutableListOf<Exercise>()
    exerciseList += Exercise("Bensh Press")
    exerciseList += Exercise("Squat")
    exerciseList += Exercise("Deadlift")
    exerciseList += Exercise("Cable Flys")
    exerciseList += Exercise("Pull Ups")
    return exerciseList
}
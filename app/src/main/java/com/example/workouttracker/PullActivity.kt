package com.example.workouttracker


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)
        val workoutName = findViewById<TextView>(R.id.workoutName)
        workoutName.text = intent.getStringExtra(Intent.EXTRA_TEXT)

        val recyclerView = findViewById<RecyclerView>(R.id.rvExercises)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = ExerciseListAdapter(createPullExercises())
        val divider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(divider)

    }
}

fun createPullExercises():List<Exercise>{
    val exerciseList = mutableListOf<Exercise>()
    exerciseList += Exercise("Weighted Pull Ups")
    exerciseList += Exercise("Cable Rows")
    exerciseList += Exercise("Face Pulls")
    exerciseList += Exercise("Reverse Peck Deck")
    exerciseList += Exercise("Bizeps")
    return exerciseList
}

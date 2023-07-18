package com.example.workouttracker

data class ExerciseSet(
    val reps: Int,
    val weight: Double,
    val date: String,
    val exercise: String,
    val notes: String
)
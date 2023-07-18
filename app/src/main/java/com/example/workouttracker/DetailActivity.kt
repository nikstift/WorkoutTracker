package com.example.workouttracker


import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Date


class DetailActivity : AppCompatActivity() {

    private lateinit var notesEditText: EditText
    private lateinit var repsEditText: EditText
    private lateinit var weightEditText: EditText
    private val sets = mutableListOf<ExerciseSet>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val exerciseName = findViewById<TextView>(R.id.exerciseName)
        exerciseName.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        val addExercise = findViewById<FloatingActionButton>(R.id.add_exercise)

        notesEditText = findViewById(R.id.notes)
        repsEditText = findViewById(R.id.input_reps)
        weightEditText = findViewById(R.id.input_weight)

        addExercise.setOnClickListener {
            showAlertDialog()
            hideKeyboardForAllFields()
        }

    }

    fun showAlertDialog() {
        val repetitions = findViewById<TextView>(R.id.input_reps).text.toString().toInt()
        val weight = findViewById<TextView>(R.id.input_weight).text.toString().toDouble()
        val currentDate = SimpleDateFormat("yyyy-MM-dd").format(Date())
        val exerciseName = intent.getStringExtra(Intent.EXTRA_TEXT) ?: ""
        val notes = notesEditText.text.toString()

        val exerciseSet = ExerciseSet(repetitions, weight, currentDate, exerciseName, notes)

        val mdialog = MaterialAlertDialogBuilder(this)
            .setCancelable(true)
            .setTitle("Add exercise?")
            .setMessage("Do you want to add $repetitions reps of $weight KG of the exercise?")
            .setPositiveButton("Add set") { dialog, which ->
                sets.add(exerciseSet)
                showSnackbar("Awesome, well done!") }
            .setNegativeButton("Cancel") { dialog, which -> showSnackbar("Too bad, go harder!") }
        mdialog.show()
    }

    fun showSnackbar(msg: String) {
        val detailLayout = findViewById<ConstraintLayout>(R.id.detail_main)
        Snackbar.make(detailLayout, msg, Snackbar.LENGTH_SHORT).show()
    }

    private fun hideKeyboardForAllFields() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        inputMethodManager.hideSoftInputFromWindow(notesEditText.windowToken, 0)

        inputMethodManager.hideSoftInputFromWindow(repsEditText.windowToken, 0)

        inputMethodManager.hideSoftInputFromWindow(weightEditText.windowToken, 0)
    }
}
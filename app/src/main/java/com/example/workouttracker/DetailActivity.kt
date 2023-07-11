package com.example.workouttracker

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val exerciseName = findViewById<TextView>(R.id.exerciseName)
        exerciseName.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        val addExercise = findViewById<FloatingActionButton>(R.id.add_exercise)
        addExercise.setOnClickListener {
            showAlertDialog()
        }

        val notesTextView = findViewById<EditText>(R.id.notes)
        notesTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                Log.d("DetailActivity", ""+s)
            }

        })
    }

    fun showAlertDialog() {
        val repetitions = findViewById<TextView>(R.id.input_reps).text
        val weight = findViewById<TextView>(R.id.input_weight).text
        val mdialog = MaterialAlertDialogBuilder(this)
            .setCancelable(true)
            .setTitle("Add exercise?")
            .setMessage("Do you want to add $repetitions reps of $weight KG of the exercise?")
            .setPositiveButton("Add exercise") { dialog, which -> showSnackbar("Awesome, well done!") }
            .setNegativeButton("Cancel") { dialog, which -> showSnackbar("Too bad, go harder!") }
        mdialog.show()
    }

    fun showSnackbar(msg: String) {
        var detailLayout = findViewById<ConstraintLayout>(R.id.detail_main)
        Snackbar.make(detailLayout, msg, Snackbar.LENGTH_SHORT).show()

    }
}
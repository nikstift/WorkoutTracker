package com.example.workouttracker

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

const private val  LOG_TAG = "ExerciseListAdapter"

class ExerciseListAdapter(private var exerciseList: List<Exercise>): RecyclerView.Adapter<ExerciseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_exercises, parent, false)
        Log.i(LOG_TAG, "onCreateViewHolder called")
        return ExerciseViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        Log.i(LOG_TAG, "onBind called")
        val exercise = exerciseList[position]
        holder.bind(exercise)
    }

}



class ExerciseViewHolder(viewFromXmlLayout: View): RecyclerView.ViewHolder(viewFromXmlLayout) {

    private val exerciseTextView: TextView

    init {
        exerciseTextView = viewFromXmlLayout.findViewById(R.id.tvListContentExercise)
        viewFromXmlLayout.setOnClickListener {
            val context = viewFromXmlLayout.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, exerciseTextView.text)
            context.startActivity(intent)
        }
    }

    fun bind(exercise: Exercise) {
        exerciseTextView.text=exercise.name
    }

}


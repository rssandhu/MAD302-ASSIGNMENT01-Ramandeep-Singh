
/**
 * W2026 MAD302-01 – Android Development
 * Application: Assignment 1 – Course List App
 *
 * Course code: MAD302-01
 * Assignment: ASSIGNMENT 1
 * Your full name: Ramandeep Singh
 * Student ID: A00194321
 * Date of submission: 2026/03/23
 *
 * This app displays a list of courses in a RecyclerView on the main screen.
 * When the user taps a course, the app opens DetailActivity to show the course
 * code, name, and description passed via Intent extras.
 */

package com.example.assignment2
import Course
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    private val courses = listOf(
        Course("MAD302", "Android Development", "Learn Android app development in Kotlin."),
        Course("MAD201", "Web Development", "Build interactive web pages with HTML, CSS, and JavaScript."),
        Course("MAD101", "Programming Fundamentals", "Introduction to programming concepts and problem solving."),
        Course("MAD151", "Database Essentials", "Learn SQL and basic database design for web and mobile apps."),
        Course("MAD351", "Cross‑Platform Mobile", "Develop apps for Android and iOS using a shared codebase."),
        Course("MAD401", "Capstone Project", "Build a real‑world application combining all prior skills.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCourses = findViewById<RecyclerView>(R.id.rvCourses)
        rvCourses.layoutManager = LinearLayoutManager(this)
        rvCourses.adapter = CourseAdapter(courses) { course ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("CODE", course.code)
                putExtra("NAME", course.name)
                putExtra("DESCRIPTION", course.description)
            }
            startActivity(intent)
        }
    }
}

/**
 * ViewHolder for Course items in RecyclerView.
 * Holds references to the UI elements used in list_item.xml.
 */
class CourseViewHolder(
    private val itemView: View,
    private val onItemClick: (Course) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val tvCode: TextView = itemView.findViewById(R.id.tvCode)
    private val tvName: TextView = itemView.findViewById(R.id.tvName)

    /**
     * Binds a Course object to this ViewHolder’s views.
     *
     * @param course The Course object to display.
     */
    fun bind(course: Course) {
        tvCode.text = course.code
        tvName.text = course.name

        // Set click listener on the whole row.
        itemView.setOnClickListener { onItemClick(course) }
    }
}

/**
 * RecyclerView adapter for the list of Course objects.
 *
 * @property courses The list of courses to display.
 * @property onItemClick Lambda called when a course item is clicked.
 */
class CourseAdapter(
    private val courses: List<Course>,
    private val onItemClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return CourseViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount(): Int = courses.size
}

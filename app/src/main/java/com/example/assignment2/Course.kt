/**
 * Represents a course with a code, name, and description.
 * Used to populate the RecyclerView in MainActivity and show details in DetailActivity.
 *
 * @property code Course code (e.g., "MAD302").
 * @property name Course title.
 * @property description Brief description of the course.
 */
data class Course(
    val code: String,
    val name: String,
    val description: String
)
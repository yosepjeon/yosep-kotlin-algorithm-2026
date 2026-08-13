package KotlinPractice

data class StudentKt(
    val birth: String,
    val name: String
) : Comparable<StudentKt> {

    override fun compareTo(other: StudentKt): Int {
        val result = this.birth.compareTo(other.birth)
        if (result != 0) return result

        return other.name.compareTo(this.name)
    }
}

fun main() {
    val comparator1 = compareBy(StudentKt::birth)
        .thenBy { it.name }

    val student1 = StudentKt("1990-01-01", "John")
    val student2 = StudentKt("1990-01-02", "Jane")
    val student3 = StudentKt("1990-01-02", "Jane2")

    val students = mutableListOf(student1, student2, student3)

//    students.sortWith(comparator1)
    students.sort()

    students.forEach(::println)
}

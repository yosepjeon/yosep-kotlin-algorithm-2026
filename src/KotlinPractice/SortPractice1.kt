package KotlinPractice

fun main() {

    // 배열
    val meetingArray = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(3, 5),
        intArrayOf(0, 6),
        intArrayOf(5, 7),
    )

    meetingArray.sortWith (
        compareBy<IntArray> { it[1] }
            .thenByDescending { it[0] }
    )

    println("meetingArray")
    meetingArray.forEach {
        println("[${it[0]}, ${it[1]}]")
    }
    println()

    // 리스트
    val meetingList = listOf<List<Int>>(
        listOf(1, 4),
        listOf(3, 5),
        listOf(0, 6),
        listOf(5, 7),
    )

    meetingList.sortedWith (
        compareBy<List<Int>>({it[1]})
            .thenByDescending { it[0] }
    )

    println("meetingList")
    meetingList.forEach(::println)

}
package Programmers.Level1.유연근무제

class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer = 0

        var j = 1
        loop1@ for (i in 0 until schedules.size) {
            var day = startday % 7
            var isCorrect = true
            println("people ${j++}")
            println("schedules: ${schedules[i]}")
            val schedule = schedules[i]
//            println("day: $day")
            loop2@ for (time in timelogs[i]) {
                println("day: $day")
                println("day: $day, time: $time, schedule: $schedule")
                if (day == 6 || day == 0) {
                    day = (day + 1) % 7
                    continue@loop2
                }

                var limit = schedule + 10
                if (limit % 100 >= 60) {
                    limit += 40  // 60분 이상이면 1시간 올리고 60분 빼기 (100-60=40)
                }
                if (time > limit){
                    println("!!!!!!!!!!!!!day: $day, time: $time, schedule: $schedule")
                    println("$$$$$")
                    isCorrect = false
                    break@loop2
//                        continue@loop1
                }
                day++
            }

            if (isCorrect) answer++
        }

        return answer
    }
}

fun main() {
    val solution = Solution()
//  ### 1
    println(solution.solution(
        intArrayOf(700, 800, 1100),
        arrayOf(
            intArrayOf(710, 2359, 1050, 700, 650, 631, 659),
            intArrayOf(800, 801, 805, 800, 759, 810, 809),
            intArrayOf(1105, 1001, 1002, 600, 1059, 1001, 1100),
        ),
        5))
//    ### 2
//    println(
//        solution.solution(
//            intArrayOf(730, 855, 700, 720),
//            arrayOf(
//                intArrayOf(710, 700, 650, 735, 700, 931, 912),
//                intArrayOf(908, 901, 805, 815, 800, 831, 835),
//                intArrayOf(705, 701, 702, 705, 710, 710, 711),
//                intArrayOf(707, 731, 859, 913, 934, 931, 905),
//            ),
//            1
//        )
//    )
}
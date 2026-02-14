package Programmers.Level1.택배_상자_꺼내기

class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer = 0
//        println("n/w: ${n/w + 1}, w: $w, num: $num")

        val maps = Array(n/w + 1) { IntArray(w) }

        for(i in 0 .. n/w) {
            for(j in 0 until w) {
                maps[i][j] = -1
            }
        }

        var targetI = 0
        var targetJ = 0

        var height = 0
        var i = 1
        var j = 0
        while(i <= n) {
            println("height: $height, j: $j")
            if(height%2 == 0) {
                maps[height][j] = i
                if(i == num) {
                    targetI = height
                    targetJ = j
                }

                j++
                if(j == w) {
                    height++
                    j--
                }
            } else {
                maps[height][j] = i
                if(i == num) {
                    targetI = height
                    targetJ = j
                }

                j--
                if(j == -1) {
                    height++
                    j++
                }
            }

            i++
        }

        var index = targetI
        while(index <= height) {
            if(maps[index][targetJ] == -1) break
            answer++
            index++
        }

        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution(13, 3, 6))
}

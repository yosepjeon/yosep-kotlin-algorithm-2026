package Baekjoon.BFS.미로탐색2178

import java.util.LinkedList
import java.util.Scanner

class Node(val x: Int, val y: Int, val count: Int = 0)

fun main() {

    val scr = Scanner(System.`in`)
    val n = scr.nextInt()
    val m = scr.nextInt()

    val map = Array(n) { CharArray(m)}
    val visited = Array(n) {BooleanArray(m) {false} }

    for(i in 0 until n) {
        val str = scr.next().toCharArray()
        for(j in 0 until str.size) {
            map[i][j] = str[j]
        }
    }

    val queue = LinkedList<Node>()
    queue.add(Node(0, 0, 1))
    var result = Integer.MAX_VALUE

    while(!queue.isEmpty()) {
        val node = queue.poll()
        if(node.x == n-1 && node.y == m-1) {
            if(result > node.count) {
                result = node.count
            }
        }

        if(node.x + 1 < n && map[node.x + 1][node.y] == '1' && visited[node.x + 1][node.y].not()) {
            queue.add(Node(node.x + 1, node.y, node.count + 1))
            visited[node.x + 1][node.y] = true
        }

        if(node.y + 1 < m && map[node.x][node.y + 1] == '1' && visited[node.x][node.y + 1].not()) {
            queue.add(Node(node.x, node.y + 1, node.count + 1))
            visited[node.x][node.y + 1] = true
        }

        if(node.x -1 >= 0 && map[node.x - 1][node.y] == '1' && visited[node.x - 1][node.y].not()) {
            queue.add(Node(node.x - 1, node.y, node.count + 1))
            visited[node.x - 1][node.y] = true
        }

        if(node.y - 1 >= 0 && map[node.x][node.y - 1] == '1' && visited[node.x][node.y - 1].not()) {
            queue.add(Node(node.x, node.y - 1, node.count + 1))
            visited[node.x][node.y - 1] = true
        }
    }

    println(result)
}
package mazerunner

import kotlin.math.absoluteValue
import kotlin.math.pow


fun main() {
    val maze = Maze(readln())
    maze.mPrint()
}


typealias Pos = Pair<Int, Int>
fun Pos.row() = this.first
fun Pos.col() = this.second
fun Pos.distance(other: Pos, l: Double = 2.0) = (
        (this.row() - other.row()).toDouble().absoluteValue.pow(l) +
        (this.col() - other.col()).toDouble().absoluteValue.pow(l)
    ).pow(1 / l )


class Maze(val height: Int, val width: Int = height, val distance: Double = 2.0, val bound: Int = 1) {
    constructor(size: List<Int>) : this(size[0], size[1])
    constructor(string: String) : this(string.split(" ").map { it.toInt() })

    // pick a random cell (but bounds)
    var next: Pos = (bound until height - bound).random() to (bound until width - bound).random()

    private val passage = mutableSetOf(next, )
    private val frontier = frontierCells(next)


    init {
        while (frontier.isNotEmpty()) {

            next = frontier.random()
            frontier.remove(next)

            if (isValid(next)) { passage.add(next) }

            val closest = passage.filter { it.distance(next) == distance }.random()
            val inBetween = ((next.row() + closest.row()) / 2) to ((next.col() + closest.col()) / 2)
            if (isValid(inBetween)) { passage.add(inBetween) }

            if (isValid(next)) { frontier.addAll(frontierCells(next)) }
        }
    }


    private fun isValid(pos: Pos): Boolean {
        if (pos.col() == 0          && passage.any { it.col() == 0 }) return false  // only one entrance
        if (pos.col() == width - 1  && passage.any { it.col() == width - 1 }) return false  // only one exit
        if (pos.col() !in 0 until width) return false
        if (pos.row() !in bound until height - bound) return false
        return true
    }


    private fun frontierCells(currentPos: Pos, distance: Int = 2 ): MutableSet<Pos> {
        val (row, col) = currentPos
        return mutableSetOf(
            row - distance to col,
            row + distance to col,
            row to col - distance,
            row to col + distance
        ).filter { it !in passage }.toMutableSet()
    }


    fun mPrint(msg: String = "") {

        for (row in 0 until height) {
            for (col in 0 until width) {
                print(
                    when (Pos(row, col)){
                        //in setOf(next) -> NEXT_STR
                        //in frontier -> FRONTIER_STR
                        in passage -> PATH_STR
                        else -> WALL_STR
                    }
                )
            }
            println()
        }
    }


    companion object {
        const val red = "\u001b[31m"
        const val reset = "\u001b[0m"
        const val WALL_STR = "\u2588\u2588"  // ██
        const val PATH_STR = "  "
        const val FRONTIER_STR = "\u2592\u2592"  // ▒▒
        const val NEXT_STR = red + "\u2591\u2591" + reset  // ░░
    }
}
package mazerunner

import kotlin.math.absoluteValue
import kotlin.math.pow


fun main() {
    val maze = Maze(readln())
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
    constructor(size: Pos) : this(size.row(), size.col())
    constructor(string: String) : this(string.split(" ").map { it.toInt() })

    // pick a random cell (but bounds)
    var next: Pos = (bound until height - bound).random() to (bound until width - bound).random()


    private val passage = mutableSetOf<Pos>(next, )
    private val frontier = frontierCells(next).toMutableSet()

    var counter = 0



    init {
        mPrint("Start")

/*        // set it as passage
        passage.add(next)

        mPrint("")
        //

        frontier.addAll(frontierCells(next))

        mPrint()*/

        while (frontier.isNotEmpty()) {


            next = frontier.random()
            frontier.remove(next)

            mPrint("next chosen")

            if (!isValid(next)) {
                mPrint("invalid")
                continue
            }


            passage.add(next)


            mPrint("next added")

            val closest = passage.filter { it.distance(next) == distance }.random()
            val inBetween = ((next.row() + closest.row()) / 2) to ((next.col() + closest.col())) / 2
            passage.add(inBetween)

            mPrint("inBetween added")

            if (isValid(next)) {
                frontier.addAll(frontierCells(next))
            } else {
                println("invalid")
            }

            mPrint("frontier extended")

            next = Pos(-1, -1)  // only for visualization debugging
            mPrint("next removed")
        }
    }





    private fun isValid(pos: Pos): Boolean {

        if (pos.row() !in 1 until height - 1) return false
        if (pos.col() !in 0 until width) return false
        if (pos.col() == 0          && passage.any { it.col() == 0 }) return false
        if (pos.col() == width - 1  && passage.any { it.col() == width - 1 }) return false
        return true
    }


    private fun frontierCells(currentPos: Pos, distance: Int = 2 ): Set<Pos>
    {
        val (row, col) = currentPos
        val frontierCells = mutableSetOf<Pos>()
        for (i in -distance..distance step (2 * distance) ) {
            if (row + i in 1 until height - 1  &&  row + i to col !in passage) {
                frontierCells.add(row + i to col)
            }
            if (col + i in -1 until width + 1  &&  row to col + i !in passage) {
                frontierCells.add(row to col + i)
            }
        }
        return frontierCells
    }


    fun mPrint(msg: String = "") {

        println("${++counter}:${msg}       XX==$next")
        for (row in 0 until height) {
            for (col in 0 until width) {
                print(
                    when (Pos(row, col)){
                        in setOf(next) -> NEXT_STR
                        in frontier -> FRONTIER_STR
                        in passage -> PATH_STR
                        else -> WALL_STR
                    }
                )
            }
            println()
        }
        println("\n\n")
        if (counter % 10 == 0) readln()

    }


    companion object {
        const val WALL_STR = "\u2588\u2588"  // ██
        const val PATH_STR = "  "
        const val FRONTIER_STR = "\u2592\u2592"  // ▒▒
        const val NEXT_STR = "\u2591\u2591"  // ░░
    }
}
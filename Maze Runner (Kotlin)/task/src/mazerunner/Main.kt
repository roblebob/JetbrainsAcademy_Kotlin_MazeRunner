package mazerunner

const val N = 10
fun main() {
    val maze = Maze(N)
    maze.print()
}






class Maze(val n: Int) {

    private val default = arrayOf(
        arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1), // 1
        arrayOf(1, 0, 0, 1, 0, 1, 0, 0, 0, 0), // 2
        arrayOf(1, 0, 0, 1, 0, 0, 0, 1, 1, 1), // 3
        arrayOf(1, 0, 1, 1, 1, 0, 0, 0, 0, 1), // 4
        arrayOf(1, 0, 1, 0, 0, 0, 0, 0, 1, 1), // 5
        arrayOf(1, 0, 1, 0, 1, 1, 1, 0, 0, 1), // 6
        arrayOf(0, 0, 0, 0, 1, 0, 1, 0, 0, 1), // 7
        arrayOf(1, 1, 1, 0, 1, 0, 1, 0, 0, 1), // 8
        arrayOf(1, 0, 0, 0, 1, 0, 0, 0, 0, 1), // 9
        arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1), // 10
    )

    private val ground = default




/*
    private val ground = Array(n) { Array(n) { PATH_VAL } }

    fun generate() {
        // generating walls around the maze
        for (col in 0 until n) {
            for (row in 0 until n) {
                if (col == 0 || row == 0 || col == n - 1 || row == n - 1) {
                    ground[col][row] = WALL_VAL
                }
            }
        }
        // generating an entrance on the left side
        set(col = (1..n-2).random(), row = 0, value = PATH_VAL)
        // generating an exit on the right side
        ground[(1..n-2).random()][n-1] = PATH_VAL
    }
*/







    fun set(pos: Pos, value: Int) = set(pos.col, pos.row, value)
    fun set(col: Int, row: Int, value: Int) {

        if (value != WALL_VAL && value != PATH_VAL)
            throw IllegalArgumentException("value must be either WALL_VAL (1) or PATH_VAL (0)")

        if (row !in 0 until n || col !in 0 until n)
            throw IllegalArgumentException("row, col(umn) must be within the maze")

        ground[col][row] = value
    }

    fun print() {
        // substitute: PATH_VAL with PATH_STR and WALL_VAL with WALL_STR
        val out = ground.map { el -> el.map { if (it == WALL_VAL) WALL_STR else PATH_STR } }
        // joining all to one string and printing
        println(out.joinToString("\n") { it.joinToString("")})
    }

    companion object {
        const val WALL_VAL = 1
        const val WALL_STR = "\u2588\u2588"  // ██
        const val PATH_VAL = 0
        const val PATH_STR = "  "
    }

    data class Pos(val col: Int, val row: Int) {
        constructor() : this(0, 0)
    }
}
fun main() {
    val list = readln().split(" ").map { it.toInt() }
    // write your code here
    val res = list.first() + list.last()

    println(res)
}
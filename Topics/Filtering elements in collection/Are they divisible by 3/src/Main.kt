fun main() {
    val list = readln().split(" ").map { it.toInt() }
    // write your code here
    val res = list.filter { it % 3 == 0 }

    println(res)
}

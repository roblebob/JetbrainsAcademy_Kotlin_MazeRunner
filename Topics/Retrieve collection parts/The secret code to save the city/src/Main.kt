fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.zipWithNext().filterIndexed { index, _ -> index % 2 == 0 }.map { (it.first + it.second).length }
    println(res)
}
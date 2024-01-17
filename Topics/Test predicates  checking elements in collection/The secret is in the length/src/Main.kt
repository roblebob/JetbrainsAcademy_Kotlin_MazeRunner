fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.all { it.length > 4 }
    println(res)
}
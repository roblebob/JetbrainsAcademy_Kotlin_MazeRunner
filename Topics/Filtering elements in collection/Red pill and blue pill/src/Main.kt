fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.filter { it == "red" || it == "blue" }


    println(res)
}
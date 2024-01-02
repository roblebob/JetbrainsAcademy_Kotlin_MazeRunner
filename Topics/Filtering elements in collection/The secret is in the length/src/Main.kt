fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.filterIndexed { index, s -> index > 0 && s.length == 5 }

    println(res)
}
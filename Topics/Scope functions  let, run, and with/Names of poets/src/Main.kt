fun main() {
    var poet: String? = readln()
    val coolScope: String = poet?.let { name -> "Our poet is $name\n${name.lowercase().count { it == 'a' }}" } ?: ""
    println(coolScope)
}
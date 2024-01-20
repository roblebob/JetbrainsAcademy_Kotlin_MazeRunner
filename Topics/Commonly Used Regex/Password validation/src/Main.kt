fun main() {
    // write your code here
    val password = readln()
    val regex = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).+$")
    println("Password ${if (regex.matches(password)) "saved" else "is too simple"}")
}
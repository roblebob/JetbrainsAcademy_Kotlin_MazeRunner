fun main() {
    val input = readln()
    try {
        val list = input.split(",")
        if (list == listOf("")) {
            throw IllegalArgumentException()
        }
        val numbers = list.map { it.toInt() }
        val average = numbers.average()
        println(average)

    } catch (e: NumberFormatException) {
        println("Invalid input!")
    } catch (e: IllegalArgumentException) { // Write the code to handle each exception as recommended
        println("Cannot calculate average of an empty list!")
    } catch (e: Exception) {
        println("An error occurred!")
    }
}
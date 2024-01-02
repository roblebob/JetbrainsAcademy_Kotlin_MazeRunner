import kotlinx.datetime.*

fun daysForward(date: String, days: Int) {
    // Write your code here
    val instant = Instant.parse(date + "T00:00:00Z")
    val period = DateTimePeriod(days=days)
    println(instant.plus(period, TimeZone.UTC).toString().substringBefore("T"))
    //
}

fun main() {
    val date = readLine()!!
    val days = readLine()!!.toInt()
    daysForward(date, days)
}
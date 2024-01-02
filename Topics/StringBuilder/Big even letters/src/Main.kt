fun upperEvenLetters(message: String): String {
    // Write your code here
    return buildString {
        for ((index, letter) in message.withIndex()) {
            append(
                if (index % 2 == 0) {
                    letter.uppercaseChar()
                } else {
                    letter
                }
            )
        }
    }
}
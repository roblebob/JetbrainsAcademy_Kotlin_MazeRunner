fun containsOnlyAlphabets(charSequence: CharSequence): Boolean {
    // write your code here
    return charSequence.all { it.isLetter() }
}
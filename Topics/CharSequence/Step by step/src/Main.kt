fun removeEveryOtherChar(input: CharSequence): CharSequence {
    // write your code here
    return input.filterIndexed { index, _ -> index % 2 == 0  }
}
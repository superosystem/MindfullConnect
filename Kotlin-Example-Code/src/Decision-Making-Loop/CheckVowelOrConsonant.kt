package `Decision-Making-Loop`

fun main(args: Array<String>) {
    val ch = 'i'

    val vowelConsonant = if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o')  "vowel" else "consonant"

    println("$ch is $vowelConsonant")
}
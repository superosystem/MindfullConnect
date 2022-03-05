package app

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun displayLength(array: Array<*>) {
    println("Length Array is ${array.size}")
}

fun main() {
    val arrayInt = arrayOf(1, 2, 3, 4, 5)
    val arrayString = arrayOf("gusryl", "mubarok")
    displayLength(arrayInt)
    displayLength(arrayString)
}
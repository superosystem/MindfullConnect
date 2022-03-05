package app

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Invariant<T>(var data: T)

fun main() {
    val invarianString = Invariant("String")

    // val invarianString: Invariant<Any> = Invariant(100)
}
package app

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
class Covariant<out T>(val data: T) {
    fun data(): T {
        return data
    }
}

fun main() {
    val data1: Covariant<String> = Covariant("data")
    val data2: Covariant<Int> = Covariant(100)
}
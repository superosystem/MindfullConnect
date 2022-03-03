package app

import data.Car

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val toyota = Car("Toyota")
    println(toyota.brand)

    val honda = Car("Honda", "Brio")
    println(honda.brand + honda.year)
}
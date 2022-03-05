package app

import data.Smartphone

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val smartphone = Smartphone("Samsung S10", "Android")

    println(smartphone.toString())
    println(smartphone.hashCode())
}
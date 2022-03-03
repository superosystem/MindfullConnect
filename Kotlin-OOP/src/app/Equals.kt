package app

import data.Company

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val company1 = Company("Gusryl")
    val company2 = Company("Gusryl")

    println(company1 == company2)
    println(company1 == company1)
    println(company2 == company2)
}
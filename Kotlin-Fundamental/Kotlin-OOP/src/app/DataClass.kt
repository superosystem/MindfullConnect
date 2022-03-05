package app

import data.Product

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val product = Product("Indomie", 2500, "Food")

    val product2 = product.copy()
    println(product)
    println(product2)
}
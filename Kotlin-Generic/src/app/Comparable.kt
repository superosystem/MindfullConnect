package app

import data.Fruit

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main(){
    val fruit1 = Fruit("Mangga", 2)
    val fruit2 = Fruit("Mangga", 100)

    println(fruit1 > fruit2)
    println(fruit1 < fruit2)
}

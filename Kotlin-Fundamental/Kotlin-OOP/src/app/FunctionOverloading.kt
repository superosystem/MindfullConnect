package app

import data.Person

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val gusryl = Person()
    gusryl.firstName = "Gusryl"

    gusryl.sayHello("Budi")
    gusryl.sayHello("Joko", "Nugroho")
}
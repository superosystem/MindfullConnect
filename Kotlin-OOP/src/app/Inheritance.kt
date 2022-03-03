package app

import data.Manager
import data.VicePresident

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val manager = Manager("Gusryl")
    manager.sayHello("Budi")

    val vicePresident = VicePresident("Mubarok")
    manager.sayHello("Budi")
}
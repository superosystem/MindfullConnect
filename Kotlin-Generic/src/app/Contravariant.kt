package app

import data.Contravariant

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val data1: Contravariant<Any> = Contravariant()
    val data2: Contravariant<String> = data1

    data2.sayHello("Gusryl")
}
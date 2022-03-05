package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

interface Go {
    fun go(): Unit {
        println("Go!")
    }
}

interface Interaction {
    val name: String
    fun sayHello(name: String): Unit {
        println("Hello $name, my name is ${this.name}")
    }
}

class Human(override val name: String): Go {

}
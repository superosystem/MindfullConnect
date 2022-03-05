package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Contravariant<in T> {
    fun sayHello(name: T) {
        return println("Hello $name")
    }
}
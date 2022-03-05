package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Function(val name: String) {
    fun <T> sayHello(param: T) {
        println("Hello $param, my name is $name")
    }

    fun <T> lain(param: T) {

    }
}
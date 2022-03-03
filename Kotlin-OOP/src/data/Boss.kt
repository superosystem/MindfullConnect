package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Boss(val name: String) {
    class Employee(val name: String) {
        fun hi() {
            println("Hi, my name is $name, and my boss name is ")
        }
    }
}
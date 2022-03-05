package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

interface CanSayHello {
    fun sayHello(name: String)
}

open class Employee

class Manager: Employee()

class VicePresident: Employee(), CanSayHello{
    override fun sayHello(name: String) {
        println("Hello $name")
    }
}

class Company<T: Employee>(val employee: T)
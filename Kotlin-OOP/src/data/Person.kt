package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Person {
    // val itu adalah immutable tidak bisa di assign
    var firstName: String = ""
    var middleName: String? = null
    var lastName: String = ""

    fun sayHello(name: String) {
        println("Hello $name, My Name is $firstName")
    }

    fun sayHello(firstNameParam: String, lastNameParam: String) {
        println("Hello $firstNameParam $lastNameParam, My Name is $firstName")
    }

    fun run() {
        println("I'm run")
    }

    fun getFullName(): String {
        return "$firstName $middleName $lastName"
    }
}


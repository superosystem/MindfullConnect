package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Student(val name: String, val age: Int)

fun Student.sayHello(name: String) {
    println("Hello $name, my name is ${this.name}, and my age is ${this.age}")
}

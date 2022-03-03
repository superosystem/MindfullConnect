package app

import data.HandPhone
import data.Laptop

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

fun printObject(any: Any) {
    if (any is Laptop) {
        println("Laptop with name  ${any.name}")
    }else if(any is HandPhone) {
        println("Handphone with anme ${any.name}")
    }else{
        println(any)
    }
}

fun printObjectWithWhen(any: Any) {
    when (any) {
        is Laptop -> println("Laptop with name  ${any.name}")
        is HandPhone -> println("Handphone with anme ${any.name}")
        else -> println(any)
   }
}

fun printString(any: Any) {
    val value = any as? String
    println(value)
}

fun main() {
    printObject("gusryl mubarok")
    printObject(1)
    printObject(Laptop("Asus"))
    printObject(HandPhone("Samsung"))
}
package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class MyData<T, U>(val firstData: T, val secondData: U) {
    fun getData(): T = firstData

    fun getSecond(): U = secondData

    fun printData() {
        println("Data is $firstData")
    }

    fun printSecond() {
        println("Second is $secondData")
    }
}
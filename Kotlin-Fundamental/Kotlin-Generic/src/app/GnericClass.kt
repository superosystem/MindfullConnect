package app

import data.MyData

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val myDataString: MyData<String, Int> = MyData<String, Int>("Gusryl", 10)
    myDataString.printData()

    val myDataInt: MyData<Int, String> = MyData<Int, String>(10, "Gusryl")
    myDataInt.printData()
}
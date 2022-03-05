/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Calculator {

    fun divide(first: Int, second: Int): Int {
        if (second == 0) {
            throw IllegalArgumentException("Can not divide by zero")
        }else{
            return first / second
        }
    }

    fun add(first: Int, second: Int): Int {
        return first + second
    }
}
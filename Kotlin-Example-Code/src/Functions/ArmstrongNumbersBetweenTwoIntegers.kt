package Functions

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main(args: Array<String>) {
    val low = 999
    val high = 99999

    for(number in low + 1..high - 1) {
        if(checkArmstrong(number))
            print("$number ")
    }
}

fun checkArmstrong(num: Int): Boolean {
    var digits = 0
    var result = 0
    var originalNumber = num
    while(originalNumber != 0) {
        originalNumber /= 10
        ++digits
    }

    originalNumber = num

    while (originalNumber != 0) {
        val remainder = originalNumber % 10
        result += Math.pow(remainder.toDouble(), digits.toDouble()).toInt()
        originalNumber /= 10
    }

    if (result == num)
        return true

    return false
}
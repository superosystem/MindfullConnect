package Functions

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main(args: Array<String>) {
    val number = 34
    var flag = false
    for(i in 2..number / 2) {
        if(checkPrime(i)) {
            if(checkPrime(number -i)) {
                System.out.printf("%d = %d + %d\n", number, i, number - i)
                flag = true
            }
        }
    }
}

fun checkPrime(num: Int): Boolean {
    var isPrime = true
    for(i in 2..num / 2) {
        if (num % i == 0) {
            isPrime = false
            break
        }
    }
    return isPrime
}
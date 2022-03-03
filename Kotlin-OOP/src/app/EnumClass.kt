package app

import data.Gender

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val man = Gender.MALE
    val woman = Gender.FEMALE

    val allGenders: Array<Gender> = Gender.values()

    val manFromString = Gender.valueOf("MALE")
    val womanFromSrting = Gender.valueOf("FEMALE")
}

package app

import data.Person

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main () {
    val gusryl = Person()
    gusryl.firstName = "Agus"
    gusryl.middleName = "Syahril"
    gusryl.lastName = "Mubarok"

    val mubarok = Person()

    println(gusryl.firstName)
    println(gusryl.middleName)
    println(gusryl.lastName)
}
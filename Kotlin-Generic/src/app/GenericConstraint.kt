package app

import data.*
import data.Company

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Company<T>(val employee: T) where T: Employee, T: CanSayHello


fun main() {
    val data1 = Company(Manager())
    val data2 = Company(VicePresident())
}
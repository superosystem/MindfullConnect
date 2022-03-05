package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class Car(paramBrand: String, paramName: String, paramYear: Int) {

    init {
        println("Card $paramBrand dibuat")
    }

    constructor(paramBrand: String, paramName: String) : this(paramBrand, paramName, 2020) {
        println("Secondary Constructor")
    }

    constructor(paramBrand: String) : this(paramBrand, "") {
        println("Secondary Constructor 2")
    }

    var brand: String  = paramBrand
    var name: String = paramName
    var year: Int = paramYear

}
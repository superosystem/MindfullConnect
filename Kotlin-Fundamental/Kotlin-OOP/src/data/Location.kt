package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

abstract class Location(val name: String) {

}

class City(name: String) : Location(name)

class Country(name: String) : Location(name)
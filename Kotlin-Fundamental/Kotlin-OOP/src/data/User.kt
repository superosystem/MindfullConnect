package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class User(var userNameParam: String, var passswordParam: String) {

    override fun toString(): String {
        return "USer with username = $userNameParam"
    }

}
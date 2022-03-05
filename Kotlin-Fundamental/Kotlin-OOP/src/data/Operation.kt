package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

sealed class Operation(val name: String)

class Plus: Operation("Plus")
class Minus: Operation("Minus")
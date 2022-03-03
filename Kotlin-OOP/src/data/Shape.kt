package data

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

open class Shape {
    open val corner: Int = -1
}

class Rectangle: Shape() {
    override val corner: Int = 4
    val parentCorner: Int = super.corner
}
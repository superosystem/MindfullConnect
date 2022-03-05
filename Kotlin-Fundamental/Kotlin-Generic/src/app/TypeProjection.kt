package app

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
class Container<T>(var data: T)

fun copy(from: Container<out Any>, to: Container<in Any>){
    to.data = from.data
}

fun main() {
    val data1 = Container("Data 1")
    val data2: Container<Any> = Container("Data 2")
    copy(data1, data2)
}
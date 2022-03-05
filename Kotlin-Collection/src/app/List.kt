package app

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val list: List<String> = listOf("Agus", "Syahril", "Mubarok")
    println(list[0])
    println(list.indexOf("Syahril"))
    println(list.contains("Mubarok"))
    println(list.containsAll(listOf("Gusryl", "Mubarok")))
    println(list.isEmpty())
    println(list.isNotEmpty())
}
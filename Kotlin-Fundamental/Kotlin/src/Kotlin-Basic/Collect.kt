fun main() {
    var map = hashMapOf(1 to "Gusryl", 2 to "Mubarok")
    map.put(3, "Syahril")

    println(map.get(3))
    println(map[3])

    var arr = arrayOf(1, 10, 22, 11)
    println(arr[0])

    var list = mutableListOf(11, 22, 33, 44)
    list[0] = 22
    for (item in list) {
        println(item)
    }
}

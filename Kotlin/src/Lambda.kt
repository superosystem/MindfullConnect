class Lambda {
    fun main() {
        println(name("Academiy"))
    }

    val name: (String) -> String = { value ->
        val first = "Gusryl"

        "$first $value"
    }
}
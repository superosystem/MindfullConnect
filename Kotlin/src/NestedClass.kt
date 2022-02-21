class Outer {
    private val name:String? = null

    class Nested {
        fun show() {
            println("nested")
        }
    }
}

fun main(args:Array<String>) {
    var outer = Outer()
}
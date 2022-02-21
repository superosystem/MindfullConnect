class Operations() {
    fun sum(n1:Int, n2:Int) :Int {
        return n1+n2
    }

    fun div(n1:Int, n2:Int) :Int {
        return n1/n2
    }
}

fun main(args:Array<String>) {
    var op = Operations()
    var sum = op.sum(10, 15)
    var div = op.div(100, 10)
}
open class Operation1{
    open fun sum(n1:Int, n2:Int) :Int {
        return n1+n2
    }

    fun div(n1:Int, n2:Int) :Int {
        return n1/n2
    }
}

class MultiOperation1() :Operation1() {
    override fun sum(n1:Int, n2:Int) :Int {
        return n1+n2
    }

    fun division(n1:Int, n2:Int) :Int {
        return n1/n2
    }
}
class UserAdmins<T> (credit:T) {
    init {
        println(credit)
    }
}

fun main(args:Array<String>) {
    var userAdmin = UserAdmins<String>("Gusryl")
    var numberAdmin = UserAdmins<Int>(12345)
}
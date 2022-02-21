abstract class CreaditCard {
    fun CreaditId():String { return "123243fdsfsd" }
}

class UserInfo(): CreaditCard() {
    fun getInfo():String {
        return CreaditId();
    }
}

fun main(args:Array<String>) {
//    var creadit = CreaditCard()
//    println(creadit.CreaditId())
    var user = UserInfo()
    user.getInfo();
}
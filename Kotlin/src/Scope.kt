var name:String?=null

fun showUserInfo(){
    name="Welcome $name"
    println(" $name")

}


fun main() {
    name = "Gusryl"
    println(" $name")
    showUserInfo()
    println(" $name")
}

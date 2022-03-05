fun main(args:Array<String>) {
    try {
        print("Enter N2: ")

    var n2:Int = readLine()!!.toInt()
    var Div = 100/n2

    print("Division: $Div")
    }catch(ex:Exception){
        println(ex.message)
    }
    print("App is Done")
}
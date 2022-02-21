fun main(args:Array<String>) {
    print("Enter your full name: ")
    val name = readLine()
    print("Enter your age: ")
    var age:Int = readLine()!!.toInt()
    print("Enter your Department: ")
    var dep:String?
    dep= readLine()
    print("Enter pi: ")
    // val cannot be change be automaticlly
    val pi:Double = readLine()!!.toDouble()
    println()
    println("***PROFILE***")
    println("Name: " + name)
    println("Age: " + age)
    println("Department: " + dep)
    println("pi: " + pi)

}
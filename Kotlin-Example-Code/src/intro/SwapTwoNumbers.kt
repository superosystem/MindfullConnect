fun main(args: Array<String>) {
    var first = 1.20f
    var second = 2.45f

    println("--- Before Swap ---")
    println("First Number  = $first")
    println("Second Number = $second")

    val temporary = first

    first = second

    second = temporary

    println("--- After Swap ---")
    println("First Number =  $first")
    println("Second Number = $second")
}
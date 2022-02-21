import java.util.Calendar

fun main() {
    print("Enter Year of Birth: ")
    val yearOfBirth = readLine()!!.toInt()
    val yearInDevice = Calendar.getInstance().get(Calendar.YEAR)
    val age = yearInDevice - yearOfBirth

    println("You are $age years old.")
}
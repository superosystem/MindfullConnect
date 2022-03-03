package app

import data.User

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun main() {
    val user1 = User("Gusryl", "Rahasia1234")
    val user2 = User("Mubarok", "Rahasia67890")

    println(user1.userNameParam)
    println(user2.userNameParam)
}
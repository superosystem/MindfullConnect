import java.util.*


fun main(){

    var listOfUsers = HashMap<Int,String>()
    listOfUsers[123]= "Apple"
    listOfUsers[554]= "Orange"
    listOfUsers[12]= "Grave"

    listOfUsers[123]= "Pinnaple"

    for (key in listOfUsers.keys)
        println("$key: ${listOfUsers[key]}")



}
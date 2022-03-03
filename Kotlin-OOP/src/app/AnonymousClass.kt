package app

import data.Action

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */
 
fun fireAction(action: Action) {
    action.action()
}

class SampleAction: Action {
    override fun action() {
        println("this is sample action")
    }
}

fun main() {
    fireAction(object : Action) {
        override fun action() = println("Action One")
    }
}
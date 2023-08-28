fun main() {
    /*
* NOTES:
* - function overloading is when you have functions with the sam name but different parameters
*/
    varArgPractice(
        "dave",
        "mike",
        "josh",
        "fred",
        "bob",
    )

    higherOrderFunctionPractice()
}

fun varArgPractice(vararg names: String) {
    for (name in names) {
        println(name)
    }
}

fun higherOrderFunctionPractice() {
    val name = "ben davies"

    //when using lambda functions , you put the arguments within the parentheses and the lambda outside the parentheses
    logUserName(name) {
        println("welcome back $name")
    }

}

//higher order function : function that takes a function as a parameter
fun logUserName(userName: String, displayInfo: (String) -> Unit) {
    displayInfo(userName)
}
import classes.SchoolEvent

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

    scopeFunctionsPractice()
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

/*
* NOTES:
* - let scope function only executes if the variable is not null
* - let can also be used for assigning , where it always returns the last line's type
* - also is used for doing some additional modifications (it's quite similar to apply , it returns the object back)
* - apply is used to make multiple changes to an object (similar to also) , apply returns back the object
* - with performs a block of code on an object (similar to let) directly so there's no need to use the 'it' object, as it's accessed directly
*/
fun scopeFunctionsPractice() {
    val show = SchoolEvent(name = "prom night", duration = "4hrs", isCanceled = false)
    val emptyEvent : SchoolEvent?  = null

    //it returns the last line's type if it's not null else return a default value
    val nameTag = emptyEvent?.let {
        //would get here when it's not null
        it.name.plus("--")
    } ?: ""

    //also is used to do some additional modifications
    show.also {
        it.name = "welcome to ${it.name} !!!"
        println(show.name)
    }

    //apply is used to make multiple changes to an object (similar to also)
    show.apply {
        //add modifications to the object
    }

    //with use-case is to perform a sequence of actions that can run right on the object
    with(show){
        isCanceled = true
        duration = "1hr"
    }


}
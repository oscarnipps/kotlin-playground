package basics

fun main() {
    showExceptionPractice()
}

fun showExceptionPractice() {
    /*
    * Note :
    *
    * - catch exceptions with try catch block
    *
    * - 'finally' block would be executed regardless or not an error occurred o
    */
    val studentCount = ""

    //would throw a 'NumberFormatException'
    try {
        println("${studentCount.toInt()}")
    } catch (e : NumberFormatException) {
        println(e.cause)
        println(e.message)
        println(e.localizedMessage)
    }finally {
        println("flow continued...")
    }


    val cardNumber = ""

    cardNumber.ifEmpty {
        throw ArithmeticException("card number is invalid...")
    }

}
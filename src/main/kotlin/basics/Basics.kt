package basics

const val CONSTANT_TYPE = "constant value"

fun main() {
    //showStringPractice()
    //showNumberPractice()
}

fun showStringPractice() {
    println("\"string with quotes\"")

    println("string with backslash \\")

    println("string with new line \n")

    println("string with new line \n")

    //using string template
    println("string with multi line : ${getMultiLineString()}")

    val name : String = "james bond"
    showStringLength(name)

    //using constants
    println(CONSTANT_TYPE)
}

fun showCharPractice() {
    val charValue : Char = 'A'
    println("a single character : $charValue")
}

fun showNumberPractice() {
    /*
    * Notes :
    *
    * - you can convert from one type to another (i.e from int to long , however be aware of a loss when converting from a
    * large number type to a lesser number type from long to int)
    *
    * - the resulting type of operation involving two different number types would end up with the bigger type's type (
    * i.e a multiplication between two numbers of type int and byte would have the result type of int )
    *
    * - byte < short < int < long < float < double (double is the highest)
    */
    var age : Int = 10

    var population : Long= 100000

    var interestRate : Float = 10.5F

    var populationSizeAverage : Double = 10.56832

    println("$age is of type : ${age::class.java}")

    println("$population is of type : ${population::class.java}")

    println("$interestRate is of type : ${interestRate::class.java}")

    println("$populationSizeAverage is of type : ${populationSizeAverage::class.java}")
}


fun getMultiLineString() : String {
    return """
         Good Day,
         
         Welcome to the new session and we wish you the very best!!
         
         Signed.
         Management
    """.trimIndent()
}

fun showStringLength(value: String) {
    println("$value has length of ${value.length}")
}



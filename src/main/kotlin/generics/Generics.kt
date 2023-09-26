package generics

fun main() {
    genericsPractice()
}

fun genericsPractice() {
    val apple = Apple()

    val orange = Orange()

    apple.showName()

    orange.showName()

    displayWeight(apple)

    displayWeight(orange)

    val intLogger = Logger<Int>()

    val stringLogger = Logger<String>()

    intLogger.displayContent(100)

    stringLogger.displayContent("items to display")
}

//generic method
fun <T : Fruit> displayWeight(item : T) {
    println(item.weight())
}

abstract class Fruit{
    abstract fun weight() : String
}

class Apple : Fruit(){
    override fun weight(): String {
        return "apple weighs : 0.9kg"
    }
}

class Orange : Fruit(){
    override fun weight(): String {
        return "orange weighs : 1.1kg"
    }
}

//generic class
class Logger<T> {
    fun displayContent(content : T) {
        println(content)
    }
}

//generics in extension function
fun <T : Fruit>T.showName() {
   println("from extension function -> ${weight()}")
}

//Generics with 'in' and 'out' types
//producers are covariant (read only) meaning they accept subtypes and are done using the 'out' keyword
//consumers are contravariant (write only) meaning they accept supertypes and are done using the 'in' keyword
//reified allows access to the class information using reflection without passing an instance of the class

package designpatterns

//Notes : Singleton Design Pattern
//creational pattern used to ensure only one instance exists
fun main() {
    val instance1 = SingletonClass.instance()
    val instance2 = SingletonClass.instance()
    //would be the same instance
    println("instance1 is same as instance2 ${instance1 == instance2}")
}

//only one instance would be available in memory
object SingletonClass{
    // fields / methods
    fun instance() : SingletonClass = apply {
        this
    }
}
package design_patterns


fun main(args: Array<String>){
    SingletonPatternKotlin()

}

class SingletonPatternKotlin {
    val singleton1 = Singleton.performSomeAction()  //all the same instance
    val singleton2 = Singleton.performSomeAction()  //all the same instance
    val singleton3 = Singleton.performSomeAction()  //all the same instance
}

object Singleton {
    //this is initialized once when the object is accessed i.e Singleton.performSomeAction
    init {
        println("instance is created")
    }

    fun performSomeAction() {
    }
}
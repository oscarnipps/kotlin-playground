package classes

fun main() {
}

/*
* NOTES:
* - if there are modifiers  after the class name you should add the 'constructor' before the opening parenthesis
* - if there's a special need for multiple constructors you can proceed with else use default parameter values instead
* - class with multiple secondary constructors are chained i.e there's always a call to the primary constructor,
*   it keeps calling constructors as long as there is a constructor with that signature so if a constructor with that
*   signature does not there would be a compilation error)
*/
class Lesson(var lessonName : String, var lessonDuration : String ,var lessonInstructor : String){

    //secondary constructor 1
    constructor(lessonName :String , lessonInstructor :String ) : this (lessonName,"30 minutes",lessonInstructor)


    //this constructor would call secondary constructor 1 because the signature matches
    constructor(lessonName :String) : this (lessonName , "")
}


/*
* NOTES:
* - for a class with multiple constructors , you can omit adding the parameters to the class declaration
*/
class Student{

    constructor(name : String){
        this.name = name
    }

    constructor(name : String , noOfCourses : Int){
        this.name = name
        this.noOfCourses = noOfCourses
    }

    var name = ""
    var noOfCourses = 0
    var level = 1
    var isFullyRegistered = false
}

/*
* NOTES:
* - for a class with single constructors , you can omit the constructor and just add the parameters to the class definition
*/
class ClassPeriod(var periodDuration : Int , var isPeriodCanceled : Boolean)



/*
* NOTES:
* - Class with getters and setter
* - getters and setters are called every time the field is used to retrieve or set the value
*/
class ClassRoom{
    var capacity = 100

    var currentOngoingClass = ""

    var currentOngoingTeacher = ""

    var classTag = ""
        get() = "$currentOngoingTeacher : \"$currentOngoingClass\""
        set(value) {
            field = value //field here in this case refers to the actual variable
        }


    var studentCount = 0

    val isFull : Boolean
        get() = studentCount >= 100

}


/*
* NOTES:
* - class with init block and companion object
* - init block would be run as soon as the class is instantiated (created)
*/
class StudentLoan(var accountName : String, var accountNumber : Int){


    init {
        accountName = ALIAS.plus(accountName)
    }

    companion object {
        const val ALIAS = "Account Holder : "
    }
}


/*
* NOTES:
* - objects are like static classes in java
* - objects do not need to be created to be used ( i.e FileAccess.FILE_PREFIX)
*/
object FileAccess{
    private const val FILE_PREFIX = "file prefix"
}


/*
* NOTES:
* - kotlin classes are final by default , so adding the keyword 'open' makes the class open for inheritance
* - if the inherited class has constructors that require parameters then they should be passed to the inherited class
* - if the inherited class has properties/fields then they could also be overriden as long as the open keyword is on the variables / fields
*/
open class SchoolEvent(var name : String ,var duration : String , var isCanceled : Boolean)



/*
* NOTES:
* - 'private' scoped variables are only accessible from within the class itself
* - 'protected' scoped variables are only accessible from within the class itself and classes that inherit from it
* - 'internal' scoped variables are only accessible from within the same package
* - 'public' scoped variables are only accessible to any caller
* - 'abstract' classes can not be instantiated (objects can not be created from it)
* - 'abstract' classes can or can not have implemented functions (by adding the abstract keyword in front of the class)
* - 'interface' can have function implementation as well as variables
*/

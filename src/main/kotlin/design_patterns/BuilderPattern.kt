package design_patterns

// check links :
// - https://medium.com/kayvan-kaseb/builder-design-pattern-in-android-a38dccb75485
// - https://medium.com/mindorks/builder-pattern-vs-kotlin-dsl-c3ebaca6bc3b

fun main(args: Array<String>){
    val employee1 = Employee.Builder()
        .firstName("james")
        .lastName("bowen")
        .age("26")
        .sex("male")
        .hasVacation(true)
        .build()

    println("### employee with builder pattern ###")
    println("employee 1 : $employee1")

    //todo: use DSL for builder pattern
   //println("### employee with builder pattern using kotlin DSL ###")
   //val student = student{
   //    //assignments and initializations
   //}
}

//using non DSL format
class Employee private constructor (
    val firstName : String,
    val lastName : String,
    val age : String,
    val sex : String,
    val hasVacation : Boolean
){

    class Builder{
        private var firstName = ""

        private var lastName = ""

        private var age = "N/A"

        private var sex = "N/A"

        private var hasVacation = false

        fun firstName (firstName : String) = apply { this.firstName = firstName }

        fun lastName (lastName : String) = apply { this.lastName = lastName }

        fun age (age : String) = apply { this.age = age }

        fun sex (sex : String) = apply { this.sex = sex }

        fun hasVacation (hasVacation : Boolean) = apply { this.hasVacation = hasVacation }

        fun build() = Employee(
           firstName,
           lastName,
           age,
           sex,
           hasVacation
        )
    }

    override fun toString(): String {
        return "{${this.firstName}, ${this.lastName} ,${this.age} ,${this.sex} ,${this.hasVacation}}"
    }
}

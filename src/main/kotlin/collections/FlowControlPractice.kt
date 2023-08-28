package collections

fun main() {
    whenLoopPractice()
}

fun whenLoopPractice() {
    /*
    * NOTES:
    * - when is Exhaustive if it's returning a value i.e would need to have a when branch
    * - can capture a subject i.e assign a variable in the conditon block and use it within the block
    */

    //using basic when
    val subType = "premium"
    when (subType) {
        "basic" -> println("subscription type is basic")
        "premium" -> println("subscription type is premium")
        "classic" -> println("subscription type is classic")
        "gold" -> {
            println("subscription type does not exist")
        }
        else -> {

        }
    }

    //using while to return value
    val subTypeCode = when (subType) {
        "basic" -> 1
        "premium" -> 2
        "classic" -> 3
        "gold" -> 4
        else -> 0
    }
    println("subscription type code is $subTypeCode")

    //using when with capturing the subject
   val isTypeValid = when (val count = subType.length) {
        in 0..4 ->  true
        in 5..10 ->  true
        in 11..15 ->  true
       else -> false
    }
    println("subscription type is valid : $isTypeValid")

}

fun forLoopPractice() {
    /*
    * NOTES:
    * - the lower and upper bounds are inclusive (would be part of the iteration i.e 1 and 5 would both used)
    * - can also loop with skips
    */

    //looping through ascending ranges
    val reps = 5
    for (rep in 1..reps) {
        println( "squat rep out of ($reps) : $rep")
    }

    //looping through descending ranges
    val pullUps = 5
    for (rep in pullUps downTo 1) {
        println( "pullUp rep out of ($pullUps) : $rep")
    }

    //looping through ranges with skips
    val superSets = 10
    for (rep in superSets downTo 1 step 2) {
        println( "pullUp rep out of ($superSets) : $rep")
    }

    //looping through collections
    val items = listOf("shoe","tie","socks","shirt")
    for (item in items) {
        println( "item $item in cart")
    }
}

fun whileLoopPractice() {
}
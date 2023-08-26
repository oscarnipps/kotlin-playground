package collections

fun main() {
    forLoopPractice()
}

fun whenLoopPractice() {

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
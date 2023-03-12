package drinks

abstract class Drink {
    abstract fun name(): DrinkEnum
    abstract fun price(): Int
    fun process() {
        println("${name()} ordered successfully! Preparing ...")
        println("Drink prepared successfully! Take it! 😃")
    }
}
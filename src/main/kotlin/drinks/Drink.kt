package drinks

abstract class Drink {
    abstract fun name(): DrinkType
    abstract fun price(): Int
    fun prepare() {
        println("${name()} ordered successfully! Preparing ...")
        println("Drink prepared successfully! Take it! 😃")
    }
}
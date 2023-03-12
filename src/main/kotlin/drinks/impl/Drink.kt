package drinks.impl

import drinks.DrinkType

sealed interface Drink {
    fun name(): DrinkType
    fun price(): Int
    fun test()
    fun prepare() {
        println("${name()} ordered successfully! Preparing ...")
        println("Drink prepared successfully! Take it! 😃")
    }
}
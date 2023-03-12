package drinks.impl

import drinks.DrinkEnum

abstract class Drink {
    abstract fun name(): DrinkEnum
    abstract fun price(): Int
    fun prepare() {
        println("${name()} ordered successfully! Preparing ...")
        println("Drink prepared successfully! Take it! 😃")
    }
}
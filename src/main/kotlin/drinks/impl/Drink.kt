package drinks.impl

import drinks.DrinkType

sealed class Drink {
    abstract fun name(): DrinkType
    abstract fun price(): Int
    fun prepare() {
        println("${name()} ordered successfully! Preparing ...")
        println("Drink prepared successfully! Take it! 😃")
    }

    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }
}
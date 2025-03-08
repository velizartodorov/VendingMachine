package drinks.impl

import coin.Coin
import order.*
import order.Status.*
import kotlin.reflect.KClass

sealed interface Drink {
    val name: String
    val price: Int
    fun prepareDrink(order: Order)

    fun prepare(order: Order): OrderResponse {
        val drink = order.drink ?: throw IllegalArgumentException("Drink not specified")
        val amountPaid = Coin.get(order.coins)
        return if (amountPaid >= price) {
            val change = amountPaid - price
            println("$name ordered successfully! Preparing ...")
            prepareDrink(order)
            println("$name prepared successfully! Take it!")
            if (change > 0) {
                println("Take your change: ${Coin.format(change)}")
            }
            OrderResponse(Coin.get(change), DONE, drink)
        } else {
            throw IllegalArgumentException(insufficientFundsMessage(order))
        }
    }

    private fun insufficientFundsMessage(order: Order) = """
        Amount insufficient for $name! 
        Needed: ${Coin.format(price)} 
        Provided: ${Coin.format(order.coins)}
    """.trimIndent()

    fun getAmount(strength: Strength?): Amount = when (strength) {
        Strength.LOW -> Amount.LOW
        Strength.MEDIUM -> Amount.MEDIUM
        Strength.HIGH -> Amount.HIGH
        Strength.MAX -> Amount.MAX
        else -> throw IllegalArgumentException("Invalid strength: $strength")
    }

    fun getAmount(drink: String?): Amount = if (drink == "Water") Amount.MAX else Amount.MEDIUM

    companion object {

        private val availableDrinks: List<Drink> by lazy {
            Drink::class.sealedSubclasses.mapNotNull { it.createInstance() }
        }

        private fun KClass<out Drink>.createInstance(): Drink? =
            constructors.find { it.parameters.isEmpty() }?.call()

        fun get(number: Int?): String {
            return number?.takeIf { it in 1..availableDrinks.size }
                ?.let { availableDrinks[it - 1].name }
                ?: throw IllegalArgumentException("Invalid drink number: $number")
        }

        fun getDrink(drinkType: String?): Drink {
            return availableDrinks.find { it.name == drinkType }
                ?: throw IllegalArgumentException("Drink not found: $drinkType")
        }
    }
}

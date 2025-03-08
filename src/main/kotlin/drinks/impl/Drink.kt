package drinks.impl

import coin.Coin
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Amount
import order.Order
import order.OrderResponse
import order.Status.DONE
import order.Status.IN_PROGRESS
import order.Strength
import order.Strength.*
import kotlin.reflect.KClass

sealed interface Drink {
    val name: String
    val price: Int
    fun prepareDrink(order: Order)

    fun prepare(order: Order): OrderResponse {
        val drink = order.drink ?: throw IllegalArgumentException("Drink not specified")
        val amount = Coin.get(order.coins)
        val change = amount - price
        val status = if (amount >= price) DONE else IN_PROGRESS
        val orderResponse = OrderResponse(Coin.get(change), status, drink)
        if (amount >= price) {
            println("$name ordered successfully! Preparing ...")
            prepareDrink(order)
            if (orderResponse.status == DONE) {
                println("$name prepared successfully! Take it!")
            }
            if (change > 0) {
                val formatChange = Coin.format(orderResponse.change)
                println("Take your change: $formatChange")
            }
        } else {
            throw IllegalArgumentException(getErrorMessage(order))
        }
        return orderResponse
    }

    private fun getErrorMessage(order: Order) =
        """
        Amount insufficient for ${name}! 
        Needed amount: ${Coin.format(price)} 
        Current amount: ${Coin.format(order.coins)}
        """

    fun getAmount(strength: Strength?): Amount = when (strength) {
        LOW -> Amount.LOW
        MEDIUM -> Amount.MEDIUM
        HIGH -> Amount.HIGH
        MAX -> Amount.MAX
        else -> throw IllegalArgumentException("Strength undetermined: $strength")
    }

    fun getAmount(drink: String?): Amount = when (drink) {
        "Water" -> Amount.MAX
        else -> Amount.MEDIUM
    }

    companion object {

        fun get(number: Int?): String {
            val drinks = Drink::class.sealedSubclasses.map { drinkClass ->
                val constructor = drinkClass.constructors.find { it.parameters.isEmpty() }
                    ?: throw IllegalArgumentException("No suitable constructor found")
                constructor.call()
            }
            return number?.minus(1)?.let { drinks.getOrNull(it)?.name }
                ?: throw IllegalArgumentException("Number unsupported: $number")
        }

        fun getDrink(drinkType: String?): Drink {
            val drinks = Drink::class.sealedSubclasses
            for (drinkClass: KClass<out Drink> in drinks) {
                val constructor = drinkClass.constructors.find { it.parameters.isEmpty() }
                    ?: throw IllegalArgumentException("No suitable constructor found")
                val drink = constructor.call()
                if (drink.name == drinkType) return drink
            }
            throw NotImplementedException("Drink doesn't exist: $drinkType")
        }
    }

}
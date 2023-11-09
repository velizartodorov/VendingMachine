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
import kotlin.reflect.full.createInstance

sealed class Drink {
    abstract val name: String
    abstract val price: Int
    protected abstract fun prepareDrink(order: Order)

    fun prepare(order: Order): OrderResponse {
        val drink = order.drink ?: throw IllegalArgumentException("Drink not specified")
        val amount = getAmount(order.coins)
        val change = amount - price
        val status = if (amount >= price) DONE else IN_PROGRESS
        val orderResponse = OrderResponse(getChange(change), status, drink)
        println("$name ordered successfully! Preparing ...")
        prepareDrink(order)
        if (change > 0) {
            println("Take your change: ${orderResponse.change}")
        }
        if (orderResponse.status == DONE) {
            println("$name prepared successfully! Take it!")
        } else {
            throw IllegalArgumentException(getErrorMessage(order))
        }
        return orderResponse
    }

    private fun getChange(change: Int): List<Coin> {
        val coins = mutableListOf<Coin>()
        var remainingChange = change
        for (coin in Coin.descending) {
            while (remainingChange >= coin.value) {
                coins.add(coin)
                remainingChange -= coin.value
            }
        }
        return coins
    }

    private fun getErrorMessage(order: Order) =
        "Amount insufficient for $name! " +
                "Needed amount: $price " +
                "Current amount: ${getAmount(order.coins)}"

    override fun equals(other: Any?): Boolean {
        return other?.javaClass != this.javaClass
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

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
        fun getDrink(drinkType: String?): Drink {
            val drinks = Drink::class.sealedSubclasses
            for (drinkClass: KClass<out Drink> in drinks) {
                val drink: Drink = drinkClass.createInstance()
                if (drink.name == drinkType) return drink
            }
            throw NotImplementedException("Drink doesn't exist: $drinkType")
        }

        fun get(number: Int?): String {
            val drinks = Drink::class.sealedSubclasses.map { it.createInstance() }
            return number?.minus(1)?.let { drinks.getOrNull(it)?.name }
                ?: throw IllegalArgumentException("Number unsupported: $number")
        }

        fun getAmount(coins: List<Coin>?): Int {
            return coins?.sumOf { it.value } ?: 0
        }

    }
}
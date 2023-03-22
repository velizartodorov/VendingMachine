package order

import coin.Coin
import com.google.gson.Gson
import drinks.DrinkType

class Order private constructor(
    val drink: DrinkType?,
    val milk: Amount?,
    val sugar: Amount?,
    val strength: Strength?,
    val coins: Coin?
) {
    data class Builder(
        var drink: DrinkType? = null,
        var milk: Amount? = null,
        var sugar: Amount? = null,
        var strength: Strength? = null,
        var coins: Coin? = null
    ) {
        fun drink(drink: DrinkType) = apply { this.drink = drink }
        fun withMilk(milk: Amount) = apply { this.milk = milk }
        fun withSugar(milk: Amount) = apply { this.sugar = milk }
        fun withStrength(size: Strength) = apply { this.strength = size }
        fun withCoins(coins: Coin) = apply { this.coins = coins }
        fun build() = Order(drink, milk, sugar, strength, coins)
    }

    override fun toString(): String = Gson().toJson(this)
}
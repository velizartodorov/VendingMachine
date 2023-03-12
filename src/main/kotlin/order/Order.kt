package order

import com.google.gson.Gson
import drinks.DrinkEnum

class Order private constructor(
    val drink: DrinkEnum?,
    val milk: Amount?,
    val sugar: Amount?,
    val strength: Amount?,
    val coins: Int?
) {
    data class Builder(
        var drink: DrinkEnum? = null,
        var milk: Amount? = null,
        var sugar: Amount? = null,
        var strength: Amount? = null,
        var coins: Int? = null
    ) {

        fun drink(drink: DrinkEnum) = apply { this.drink = drink }
        fun withMilk(milk: Amount) = apply { this.milk = milk }
        fun withSugar(milk: Amount) = apply { this.sugar = milk }
        fun withStrength(size: Amount) = apply { this.strength = size }
        fun withCoins(coins: Int) = apply { this.coins = coins }
        fun build() = Order(drink, milk, sugar, strength, coins)
    }

    override fun toString(): String = Gson().toJson(this)
}
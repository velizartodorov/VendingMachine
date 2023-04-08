package order

import coin.Coin
import com.google.gson.Gson

data class Order(
    val drink: String?,
    val milk: Amount?,
    val sugar: Amount?,
    val strength: Strength?,
    val coins: List<Coin>?,
) {
    class Builder {
        private var drink: String? = null
        private var milk: Amount? = null
        private var sugar: Amount? = null
        private var strength: Strength? = null
        private var coins: List<Coin>? = null

        fun drink(drink: String) = apply { this.drink = drink }
        fun withMilk(milk: Amount) = apply { this.milk = milk }
        fun withSugar(sugar: Amount) = apply { this.sugar = sugar }
        fun withStrength(strength: Strength) = apply { this.strength = strength }
        fun withCoins(vararg coins: Coin) = apply { this.coins = coins.toList() }

        fun build() = Order(drink, milk, sugar, strength, coins)
    }

    override fun toString(): String = Gson().toJson(this)
}
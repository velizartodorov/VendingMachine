package order

import coin.Coin
import com.google.gson.Gson
import order.Amount.MEDIUM

data class Order(
    var drink: String?,
    var milk: Amount?,
    var water: Amount?,
    var sugar: Amount?,
    var strength: Strength?,
    var coins: List<Coin>?,
) {
    class Builder {
        private var drink: String? = null
        private var milk: Amount? = null
        private var water: Amount? = MEDIUM
        private var sugar: Amount? = null
        private var strength: Strength? = null
        private var coins: List<Coin>? = null

        fun drink(drink: String) = apply { this.drink = drink }
        fun withMilk(milk: Amount) = apply { this.milk = milk }
        fun withWater(water: Amount) = apply { this.water = water }
        fun withSugar(sugar: Amount) = apply { this.sugar = sugar }
        fun withStrength(strength: Strength) = apply { this.strength = strength }
        fun withCoins(vararg coins: Coin) = apply { this.coins = coins.toList() }

        fun build() = Order(drink, milk, water, sugar, strength, coins)
    }

    override fun toString(): String = Gson().toJson(this)
}
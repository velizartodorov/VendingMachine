package order

import coin.Coin
import com.google.gson.Gson
import order.Amount.MEDIUM

data class Order(
    var drink: String?,
    var milk: Amount?,
    var water: Amount? = MEDIUM,
    var sugar: Amount?,
    var strength: Strength?,
    var coins: List<Coin>
) {

    fun drink(drink: String) {
        apply { this.drink = drink }
    }

    fun milk(milk: Amount) {
        apply { this.milk = milk }
    }

    fun coins(coins: Array<Coin>) {
        apply { this.coins = coins.toList() }
    }

    fun sugar(sugar: Amount) {
        apply { this.sugar = sugar }
    }

    fun strength(strength: Strength) {
        apply { this.strength = strength }
    }

    override fun toString(): String = Gson().toJson(this)
}
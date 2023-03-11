package order

import com.google.gson.Gson
import order.Amount.MEDIUM
import order.Drink.COFFEE

class Order {
    var drink: Drink = COFFEE
    var milk: Amount = MEDIUM
    var sugar: Amount = MEDIUM
    var strength: Amount = MEDIUM
    var price: Int? = null

    data class Builder(
        var drink: Drink? = null,
        var milk: Amount? = null,
        var sugar: Amount? = null,
        var strength: Amount? = null,
        var price: Int? = null
    ) {

        fun drink(drink: Drink) = apply { this.drink = drink }
        fun withMilk(milk: Amount) = apply { this.milk = milk }
        fun withSugar(milk: Amount) = apply { this.sugar = milk }
        fun withStrength(size: Amount) = apply { this.strength = size }
        fun withPrice(price: Int) = apply { this.price = price }
        fun order() = Order()
    }

    override fun toString(): String = Gson().toJson(this)
}
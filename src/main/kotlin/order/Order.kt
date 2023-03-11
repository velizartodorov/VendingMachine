package order

import com.google.gson.Gson
import order.Amount.MEDIUM
import order.Drink.COFFEE
import order.DrinkSize.SMALL

class Order {
    var drink: Drink = COFFEE
    var milk: Amount = MEDIUM
    var sugar: Amount = MEDIUM
    var size: DrinkSize = SMALL
    var price: Int? = null

    data class Builder(
        var drink: Drink? = null,
        var milk: Amount? = null,
        var sugar: Amount? = null,
        var size: Amount? = null,
        var price: Int? = null
    ) {

        fun drink(drink: Drink) = apply { this.drink = drink }
        fun withMilk(milk: Amount) = apply { this.milk = milk }
        fun withSugar(milk: Amount) = apply { this.sugar = milk }
        fun withSize(size: Amount) = apply { this.size = size }
        fun withPrice(price: Int) = apply { this.price = price }
        fun order() = Order()
    }

    override fun toString(): String = Gson().toJson(this)
}
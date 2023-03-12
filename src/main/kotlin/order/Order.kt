package order

import com.google.gson.Gson

class Order private constructor(
    val drink: DrinkEnum?,
    val milk: Amount?,
    val sugar: Amount?,
    val strength: Amount?,
    val price: Int?
) {
    data class Builder(
        var drink: DrinkEnum? = null,
        var milk: Amount? = null,
        var sugar: Amount? = null,
        var strength: Amount? = null,
        var price: Int? = null
    ) {

        fun drink(drink: DrinkEnum) = apply { this.drink = drink }
        fun withMilk(milk: Amount) = apply { this.milk = milk }
        fun withSugar(milk: Amount) = apply { this.sugar = milk }
        fun withStrength(size: Amount) = apply { this.strength = size }
        fun withPrice(price: Int) = apply { this.price = price }
        fun order() = Order(drink, milk, sugar, strength, price)
    }

    override fun toString(): String = Gson().toJson(this)
}
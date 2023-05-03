package vending_machine.intefaces

import drinks.impl.*
import order.Order

object DrinkInterface : UserInterface {

    override fun print() {
        println(
            """
    Americano: 1
    Cafe Au Lait: 2
    Cappuccino: 3
    Cortado: 4
    Decaf: 5
    Espresso: 6
    Flat White: 7
    Iced coffee: 8
    Irish coffee: 9
    Latte: 10
    Macchiato: 11
    Mocha: 12
    Tea: 13
    Water: 14
    
    ===================================
    PICK A DRINK (1 - 14):
    """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val value = readLine()!!.toInt()
        val drink = getDrinkBy(value)
        println("Drink selected: $drink")
        order.drink = drink
        return order
    }

    private fun getDrinkBy(number: Int?): String {
        return when (number) {
            1 -> Americano().name
            2 -> CafeAuLait().name
            3 -> Cappuccino().name
            4 -> Cortado().name
            5 -> Decaf().name
            6 -> Espresso().name
            7 -> FlatWhite().name
            8 -> IcedCoffee().name
            9 -> IrishCoffee().name
            10 -> Latte().name
            11 -> Macchiato().name
            12 -> Mocha().name
            13 -> Tea().name
            14 -> Water().name
            else -> throw IllegalArgumentException("Number unsupported: $number")
        }
    }

}
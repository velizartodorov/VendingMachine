package vending_machine.intefaces

import drinks.impl.Drink
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
        val drink = Drink.get(value)
        println("Drink selected: $drink")
        order.drink = drink
        return order
    }

}
package vending_machine.intefaces

import drinks.impl.Drink
import order.Order

object DrinkInterface : UserInterface {

    override fun print(order: Order) {
        println(
            """
            ====================================================================
            ██████╗ ██╗ ██████╗██╗  ██╗    ██████╗ ██████╗ ██╗███╗   ██╗██╗  ██╗
            ██╔══██╗██║██╔════╝██║ ██╔╝    ██╔══██╗██╔══██╗██║████╗  ██║██║ ██╔╝
            ██████╔╝██║██║     █████╔╝     ██║  ██║██████╔╝██║██╔██╗ ██║█████╔╝ 
            ██╔═══╝ ██║██║     ██╔═██╗     ██║  ██║██╔══██╗██║██║╚██╗██║██╔═██╗ 
            ██║     ██║╚██████╗██║  ██╗    ██████╔╝██║  ██║██║██║ ╚████║██║  ██╗
            ╚═╝     ╚═╝ ╚═════╝╚═╝  ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝
            ===================================================================
            Americano: 1   Cafe Au Lait: 2     Cappuccino: 3
            Cortado: 4     Decaf: 5           Espresso: 6
            Flat White: 7  Iced coffee: 8      Irish coffee: 9
            Latte: 10      Macchiato: 11       Mocha: 12
            Tea: 13        Water: 14
            ===================================================================
    """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val inputDrink: Int = input()

        try {
            val drink = Drink.get(inputDrink)
            println("Drink selected: $drink")
            order.drink(drink)
        } catch (e: IllegalArgumentException) {
            reprocess(e, order)
        }
        return order
    }

    private fun input(): Int {
        val inputDrink: Int
        while (true) {
            print("Please enter a drink number (1 - 14): ")
            val input = readln()
            if (input.toIntOrNull()?.let { it in 1..14 } == true) {
                inputDrink = input.toInt()
                break
            } else {
                println("Invalid input. Please enter a number between 1 and 14.")
            }
        }
        return inputDrink
    }

}
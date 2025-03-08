package vending_machine.intefaces

import coin.Coin
import drinks.impl.Drink
import order.Order

object CoinsInterface : UserInterface {

    override fun print(order: Order) {
        println(
            """
            ====================================================================================
            ███████╗███╗   ██╗████████╗███████╗██████╗      ██████╗ ██████╗ ██╗███╗   ██╗███████╗
            ██╔════╝████╗  ██║╚══██╔══╝██╔════╝██╔══██╗    ██╔════╝██╔═══██╗██║████╗  ██║██╔════╝
            █████╗  ██╔██╗ ██║   ██║   █████╗  ██████╔╝    ██║     ██║   ██║██║██╔██╗ ██║███████╗
            ██╔══╝  ██║╚██╗██║   ██║   ██╔══╝  ██╔══██╗    ██║     ██║   ██║██║██║╚██╗██║╚════██║
            ███████╗██║ ╚████║   ██║   ███████╗██║  ██║    ╚██████╗╚██████╔╝██║██║ ╚████║███████║
            ╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝╚═╝  ╚═╝     ╚═════╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝╚══════╝
            ====================================================================================
            """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val value: List<Int> = input(order)
        order.coins(Coin.format(value))
        try {
            Drink.getDrink(order.drink).prepare(order)
        } catch (e: Exception) {
            println(e.message)
            process(order)
        }
        return order
    }

    private fun input(order: Order): List<Int> {
        val drink = Drink.getDrink(order.drink)
        println("Price: ${Coin.format(drink.price)}")
        val value: List<Int>
        while (true) {
            print("Please enter the coins (only numbers allowed): ")
            val input = readln()
            if (input.all { it.isDigit() || it.isWhitespace() }) {
                value = input.split(" ")
                    .filter { it.isNotBlank() }
                    .map(String::toInt)
                break
            } else {
                println("Invalid input. Please enter only numbers separated by spaces.")
            }
        }
        return value
    }

}
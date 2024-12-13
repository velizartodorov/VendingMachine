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

    private fun insufficientAmount(
        order: Order,
        price: Int,
        amount: Int
    ) = """
        Amount insufficient for ${order.drink}! 
        Needed amount: ${Coin.format(price)} 
        Current amount: ${Coin.format(amount)}
        """

    override fun process(order: Order): Order {
        val value: List<Int> = input(order)
        val coins = Coin.format(value)
        val price = Drink.getDrink(order.drink).price
        val amount = Coin.get(coins.toList())
        val formatPrice = Coin.format(coins)
        if (amount >= price) {
            println("Amount inserted: $formatPrice")
            order.coins(*coins)
        } else {
            println(insufficientAmount(order, price, amount))
            print(order)
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
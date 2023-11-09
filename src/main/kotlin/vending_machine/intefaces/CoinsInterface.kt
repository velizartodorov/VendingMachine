package vending_machine.intefaces

import coin.Coin
import drinks.impl.Drink
import order.Order

object CoinsInterface : UserInterface {

    override fun print() {
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

    override fun process(order: Order.Builder): Order.Builder {
        val value = readln()
            .split(" ")
            .map(String::toInt)
        val coins = Coin.getArray(value)
        val price = Drink.getDrink(order.drink).price
        val amount = Drink.getAmount(coins.toList())
        if (amount >= price) {
            println("Coins inserted: ${coins.contentToString()}")
            order.withCoins(*coins)
        } else {
            println(
                """
                Amount insufficient for ${order.drink}! 
                        Needed amount: $price 
                        Current amount: $amount
                        """
            )
            print()
            process(order)
        }
        return order
    }

}
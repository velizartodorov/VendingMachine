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
            Price: ${Drink.getDrink(order.drink).price} cents
    """.trimIndent()
        )
    }

    private fun insufficientAmount(
        order: Order,
        price: Int,
        amount: Int
    ) = """
        Amount insufficient for ${order.drink}! 
        Needed amount: $price 
        Current amount: $amount
        """

    override fun process(order: Order): Order {
        val value = readln()
            .split(" ")
            .map(String::toInt)
        val coins = Coin.getArray(value)
        val price = Drink.getDrink(order.drink).price
        val amount = Drink.getAmount(coins.toList())
        if (amount >= price) {
            println("Coins inserted: ${coins.contentToString()}")
            order.coins(*coins)
        } else {
            println(insufficientAmount(order, price, amount))
            print(order)
            process(order)
        }
        return order
    }

}
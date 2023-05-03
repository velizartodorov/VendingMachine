package vending_machine.intefaces

import coin.Coin
import order.Order

object CoinsInterface : UserInterface {

    override fun print() {
        println("Enter coins: ")
    }

    override fun process(order: Order): Order {
        val value = readLine()!!
            .split(" ")
            .map(String::toInt)
        val coins = Coin.get(value)
        println("Coins inserted: $coins")
        order.coins = coins.toList()
        return order
    }
}
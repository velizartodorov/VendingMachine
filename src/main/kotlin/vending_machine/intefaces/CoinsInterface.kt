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
        val coins = getAmountBy(value)
        println("Coins inserted: $coins")
        order.coins = coins.toList()
        return order
    }

    private fun getAmountBy(coins: List<Int>): Array<Coin> {
        return Coin.get(coins)
    }
}
package vending_machine.intefaces

import coin.Coin

object CoinsInterface {

    fun print() {
        println("Enter coins: ")
    }

    fun get(coins: List<Int>): Array<Coin> {
        val amount = getAmountBy(coins)
        println("Coins inserted: $coins")
        return amount
    }

    private fun getAmountBy(coins: List<Int>): Array<Coin> {
        return Coin.getCoins(coins)
    }
}
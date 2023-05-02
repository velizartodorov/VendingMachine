package containers

import drinks.impl.Amount

@Suppress("unused")
class WaterContainer : Container() {
    override val name = "water"
    override var amount = 500.0

    override fun extractAmount(amount: Amount?) {
        reduceAmount(amount)
        println("Water extracted. Sugar amount remaining: ${this.amount} ml")
    }
}
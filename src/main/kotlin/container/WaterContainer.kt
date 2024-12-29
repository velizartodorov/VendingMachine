package container

import order.Amount

@Suppress("unused")
class WaterContainer : Container {
    override val name = "water"
    override var amount = 500.0

    override fun extractAmount(amount: Amount?) {
        reduceAmount(amount)
        println("Water extracted. Water amount remaining: ${this.amount} ml")
    }
}
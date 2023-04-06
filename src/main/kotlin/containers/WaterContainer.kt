package containers

import order.Amount

class WaterContainer : Container {
    override var amount = 500.0

    override fun extractAmount(amount: Amount) {
        reduceAmount(amount)
        println("Water extracted. Sugar amount remaining: ${this.amount} ml")
    }
}
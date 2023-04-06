package containers

import order.Amount

class MilkContainer : Container {
    override var amount = 500.0

    override fun extractAmount(amount: Amount) {
        reduceAmount(amount)
        println("Milk extracted. Milk amount remaining: ${this.amount} gr")
    }
}
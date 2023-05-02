package containers

import drinks.impl.Amount

@Suppress("unused")
class MilkContainer : Container() {
    override val name = "milk"
    override var amount = 500.0

    override fun extractAmount(amount: Amount?) {
        reduceAmount(amount)
        println("Milk extracted. Milk amount remaining: ${this.amount} gr")
    }
}
package containers

import drinks.impl.Amount

@Suppress("unused")
class SugarContainer : Container() {
    override val name = "sugar"
    override var amount = 500.0

    override fun extractAmount(amount: Amount?) {
        reduceAmount(amount)
        println("Sugar extracted. Sugar amount remaining: ${this.amount} gr")
    }
}
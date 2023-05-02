package containers

import drinks.impl.Amount

@Suppress("unused")
class TeaContainer : Container() {
    override val name = "tea"
    override var amount = 500.0

    override fun extractAmount(amount: Amount?) {
        reduceAmount(amount)
        println("Tea extracted. Tea amount remaining: ${this.amount} gr")
    }
}
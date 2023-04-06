package containers

import order.Amount

class SugarContainer : Container {
    override var amount = 500.0

    override fun extractAmount(amount: Amount) {
        reduceAmount(amount)
        println("Sugar extracted. Sugar amount remaining: ${this.amount} gr")
    }
}
package containers

import order.Amount

class TeaContainer : Container {
    override var amount = 500.0

    override fun extractAmount(amount: Amount?) {
        reduceAmount(amount)
        println("Tea extracted. Tea amount remaining: ${this.amount} gr")
    }
}
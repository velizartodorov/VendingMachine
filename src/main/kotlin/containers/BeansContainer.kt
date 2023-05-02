@file:Suppress("unused")

package containers

import drinks.impl.Amount

class BeansContainer : Container() {
    override val name = "beans"
    override var amount = 500.0

    override fun extractAmount(amount: Amount?) {
        reduceAmount(amount)
        println("Beans extracted. Beans amount remaining: ${this.amount} gr")
    }
}
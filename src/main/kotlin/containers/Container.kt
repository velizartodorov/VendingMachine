package containers

import order.Amount
import order.Amount.*

sealed class Container {
    abstract val name: String
    abstract var amount: Double

    abstract fun extractAmount(amount: Amount?)

    fun reduceAmount(amount: Amount?) {
        when (amount) {
            NONE -> println("Amount remains the same.")
            LOW -> reduceAmountForLow()
            MEDIUM -> reduceAmountForMedium()
            HIGH -> reduceAmountForHigh()
            MAX -> reduceAmountForMax()
        }
    }

    private fun reduceAmountForLow() {
        this.amount--
    }

    private fun reduceAmountForMedium() {
        this.amount = this.amount - 2
    }

    private fun reduceAmountForHigh() {
        this.amount = this.amount - 3
    }

    private fun reduceAmountForMax() {
        this.amount = this.amount - 4
    }
}
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Amount
import order.Amount.*
import kotlin.reflect.KClass

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
            null -> throw IllegalArgumentException("Amount not specified!")
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

    companion object {
        fun getContainer(containerName: String): Container {
            val containers = Container::class.sealedSubclasses
            for (containerClass: KClass<out Container> in containers) {
                val constructor = containerClass.constructors.find { it.parameters.isEmpty() }
                    ?: throw IllegalArgumentException("No suitable constructor found")
                val container = constructor.call()
                if (container.name == containerName) {
                    return checkAmount(container)
                }
            }
            throw NotImplementedException("Container doesn't exist: $containerName")
        }

        private fun checkAmount(container: Container): Container {
            if (container.amount > 0) return container
            else throw Exception(
                "Insufficient amount in container $container. " + "Amount: ${container.amount}"
            )
        }
    }

}
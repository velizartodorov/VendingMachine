package containers

import jdk.jshell.spi.ExecutionControl.NotImplementedException
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object ContainerFactory {
    fun getContainer(containerName: String): Container {
        val containers = Container::class.sealedSubclasses
        for (containerClass: KClass<out Container> in containers) {
            val container = containerClass.createInstance()
            if (container.name == containerName) {
                return checkAmount(container)
            }
        }
        throw NotImplementedException("Container doesn't exist: $containerName")
    }

    private fun checkAmount(container: Container): Container {
        if (container.amount > 0) return container
        else throw Exception("Insufficient amount in container $container. " +
                "Amount: ${container.amount}")
    }

}

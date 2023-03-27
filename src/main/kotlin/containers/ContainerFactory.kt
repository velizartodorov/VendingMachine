package containers

object ContainerFactory {
    fun getContainer(containerName: String): Container {
        val container = when (containerName.substringAfterLast('.')) {
            "beans" -> BeansContainer()
            "milk" -> MilkContainer()
            "sugar" -> SugarContainer()
            "water" -> WaterContainer()
            else -> throw Exception("Container unknown: $containerName.")
        }
        if (container.amount <= 0) {
            throw Exception("Insufficient amount in container $container. " +
                    "Amount: ${container.amount}")
        }
        return container
    }
}

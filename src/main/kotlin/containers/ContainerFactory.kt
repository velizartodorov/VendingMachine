package containers

class ContainerFactory {
    fun getContainer(container: String) =
        when (container.substringAfterLast('.')) {
            "beans" -> BeansContainer()
            "milk" -> MilkContainer()
            "sugar" -> SugarContainer()
            "water" -> WaterContainer()
            else -> throw Exception("Container unknown: $container.")
        }
}

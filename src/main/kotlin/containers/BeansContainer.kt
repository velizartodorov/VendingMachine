package containers

class BeansContainer : Container {
    override var amount = 500.0

    override fun extract() {
        amount--
        println("Beans extracted. Beans amount remaining: $amount gr")
    }
}
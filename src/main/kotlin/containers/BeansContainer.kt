package containers

class BeansContainer : Container {
    private var amount = 500.0

    override fun getAmount(): Double {
        return amount
    }

    override fun extract() {
        amount--
        println("Beans extracted. Beans amount remaining: $amount gr")
    }
}
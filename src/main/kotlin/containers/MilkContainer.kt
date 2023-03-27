package containers

class MilkContainer : Container {
    private var amount = 500.0

    override fun getAmount(): Double {
        return amount
    }

    override fun extract() {
        amount--
        println("Milk extracted. Milk amount remaining: $amount gr")
    }
}
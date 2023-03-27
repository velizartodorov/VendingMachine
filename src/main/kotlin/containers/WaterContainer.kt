package containers

class WaterContainer : Container {
    private var amount = 500.0

    override fun getAmount(): Double {
        return amount
    }

    override fun extract() {
        amount--
        println("Water extracted. Sugar amount remaining: $amount ml")
    }
}
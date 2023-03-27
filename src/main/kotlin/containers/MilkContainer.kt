package containers

class MilkContainer : Container {
    override var amount = 500.0

    override fun extract() {
        amount--
        println("Milk extracted. Milk amount remaining: $amount gr")
    }
}
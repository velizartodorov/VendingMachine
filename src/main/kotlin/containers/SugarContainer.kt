package containers

class SugarContainer : Container {
    private var amount = 500.0

    override fun getAmount(): Double {
        return amount
    }

    override fun extract() {
        amount--
        println("Sugar extracted. Sugar amount remaining: $amount gr")
    }
}
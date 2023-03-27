package containers

class SugarContainer : Container {
    override var amount = 500.0

    override fun extract() {
        amount--
        println("Sugar extracted. Sugar amount remaining: $amount gr")
    }
}
package containers

class TeaContainer : Container {
    override var amount = 500.0

    override fun extract() {
        amount--
        println("Tea extracted. Tea amount remaining: $amount gr")
    }
}
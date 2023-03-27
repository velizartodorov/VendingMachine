package containers

class WaterContainer : Container {
    override var amount = 500.0

    override fun extract() {
        amount--
        println("Water extracted. Sugar amount remaining: $amount ml")
    }
}
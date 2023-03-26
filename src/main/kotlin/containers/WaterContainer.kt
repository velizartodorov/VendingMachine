package containers

class WaterContainer : Container {
    override fun getAmount(): Double {
        return 50.0;
    }

    override fun extract() {
        print("Water extracted.")
    }
}
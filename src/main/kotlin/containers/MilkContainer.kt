package containers

class MilkContainer : Container {
    override fun getAmount(): Double {
        return 50.0;
    }

    override fun extract() {
        print("Milk extracted.")
    }
}
package containers

class SugarContainer : Container {
    override fun getAmount(): Double {
        return 50.0;
    }

    override fun extract() {
        print("Sugar extracted.")
    }
}
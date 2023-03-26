package containers

class BeansContainer : Container {
    override fun getAmount(): Double {
        return 50.0;
    }

    override fun extract() {
        print("Beans extracted.")
    }
}
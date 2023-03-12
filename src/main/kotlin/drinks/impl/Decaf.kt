package drinks.impl

import drinks.DrinkType.DECAF

class Decaf : Drink() {
    override fun name() = DECAF
    override fun price() = 80
}
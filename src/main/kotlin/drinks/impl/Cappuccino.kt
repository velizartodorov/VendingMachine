package drinks.impl

import drinks.DrinkType.CAPPUCCINO

class Cappuccino : Drink() {
    override fun name() = CAPPUCCINO
    override fun price() = 20
}
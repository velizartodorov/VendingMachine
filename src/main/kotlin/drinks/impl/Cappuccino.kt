package drinks.impl

import drinks.Drink
import drinks.DrinkEnum.CAPPUCCINO

class Cappuccino : Drink() {
    override fun name() = CAPPUCCINO
    override fun price() = 20
}
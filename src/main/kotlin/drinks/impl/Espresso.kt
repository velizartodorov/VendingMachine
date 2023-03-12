package drinks.impl

import drinks.DrinkType.ESPRESSO

class Espresso : Drink() {
    override fun name() = ESPRESSO
    override fun price() = 25
}
package drinks.impl

import drinks.DrinkType.MOCHA

class Mocha : Drink() {
    override fun name() = MOCHA
    override fun price() = 60
}
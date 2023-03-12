package drinks.impl

import drinks.DrinkType.FLAT_WHITE

class FlatWhite : Drink() {
    override fun name() = FLAT_WHITE
    override fun price() = 70
}
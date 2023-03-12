package drinks.impl

import drinks.Drink
import drinks.DrinkType.LATTE

class Latte : Drink() {
    override fun name() = LATTE
    override fun price() = 30
}
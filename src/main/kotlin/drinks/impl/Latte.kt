package drinks.impl

import drinks.DrinkEnum.LATTE

class Latte : Drink() {
    override fun name() = LATTE
    override fun price() = 30
}
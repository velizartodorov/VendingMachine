package drinks.impl

import drinks.DrinkType.IRISH_COFFEE

class IrishCoffee : Drink() {
    override fun name() = IRISH_COFFEE
    override fun price() = 90
}
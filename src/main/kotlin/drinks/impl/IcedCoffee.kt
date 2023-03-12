package drinks.impl

import drinks.DrinkType.ICED_COFFEE

class IcedCoffee : Drink() {
    override fun name() = ICED_COFFEE
    override fun price() = 100
}
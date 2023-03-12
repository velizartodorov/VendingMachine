package drinks.impl

import drinks.DrinkType.WATER

class Water : Drink() {
    override fun name() = WATER
    override fun price() = 15
}
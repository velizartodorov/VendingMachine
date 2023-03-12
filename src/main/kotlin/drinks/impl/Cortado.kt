package drinks.impl

import drinks.DrinkType.CORTADO

class Cortado : Drink() {
    override fun name() = CORTADO
    override fun price() = 50
}
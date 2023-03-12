package drinks.impl

import drinks.Drink
import drinks.DrinkEnum.AMERICANO

class Americano : Drink() {
    override fun name() = AMERICANO
    override fun price() = 50
}
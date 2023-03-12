package drinks.impl

import drinks.DrinkType
import drinks.DrinkType.TEA

class Tea : Drink() {
    override fun name(): DrinkType = TEA
    override fun price(): Int = 15
}
package drinks.impl

import drinks.DrinkType.MACCHIATO

class Macchiato : Drink() {
    override fun name() = MACCHIATO
    override fun price() = 70
}
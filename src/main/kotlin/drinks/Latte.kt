package drinks

import order.DrinkEnum.LATTE

class Latte : Drink() {
    override fun name() = LATTE
    override fun price() = 30
}
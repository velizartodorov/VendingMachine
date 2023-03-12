package drinks.impl

import drinks.DrinkType.CAFE_AU_LAIT

class CafeAuLait : Drink() {
    override fun name() = CAFE_AU_LAIT
    override fun price() = 110
}
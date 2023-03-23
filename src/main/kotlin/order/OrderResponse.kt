package order

import coin.Coin
import drinks.DrinkType
import order.Status.TO_DO

class OrderResponse {
    var change: List<Coin?> = emptyList()
    var status: Status = TO_DO
    lateinit var drink: DrinkType
}
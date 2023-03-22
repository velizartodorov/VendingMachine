package drinks.impl

import drinks.DrinkType
import order.Status
import order.Status.TO_DO

class OrderResponse {
    var change: Int = 0
    var status: Status = TO_DO
    lateinit var drink: DrinkType
}

package order

import coin.Coin
import drinks.DrinkType
import order.Status.TO_DO

data class OrderResponse(
    var change: List<Coin> = listOf(),
    var status: Status = TO_DO,
    var drink: DrinkType,
)
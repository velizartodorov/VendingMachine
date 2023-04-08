package order

import coin.Coin
import order.Status.TO_DO

data class OrderResponse(
    var change: List<Coin> = listOf(),
    var status: Status = TO_DO,
    var drink: String,
)
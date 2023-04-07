package drinks.impl

import coin.Coin.*
import drinks.DrinkType.WATER
import order.Amount.NONE
import order.Order
import order.Status.DONE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class WaterTest {
    @Test
    fun testOrderWater() {
        val drink = getWater()
        assertEquals(drink.drink, WATER)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithWater() {
        VendingMachine.start()
        val drink = getWater()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, WATER)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(FIFTY_CENTS, TWENTY_CENTS, TEN_CENTS, FIVE_CENTS))
    }

    private fun getWater() = Order.Builder()
        .drink(WATER)
        .withMilk(NONE)
        .withCoins(ONE_EURO)
        .build()
}
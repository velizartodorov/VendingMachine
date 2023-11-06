package drinks.impl

import coin.Coin.*
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
        assertEquals(drink.drink, "Water")
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithWater() {
        VendingMachine.start()
        val drink = getWater()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Water")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(FIFTY_CENTS, TWENTY_CENTS, TEN_CENTS, FIVE_CENTS))
        VendingMachine.stop()
    }

    private fun getWater() = Order.Builder()
        .drink("Water")
        .withMilk(NONE)
        .withCoins(ONE_EURO)
        .build()
}
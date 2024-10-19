package drinks.impl

import coin.Coin.TEN_CENTS
import coin.Coin.TWENTY_CENTS
import order.Status.DONE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class CappuccinoTest : CappuccinoTestHelper() {

    @Test
    fun testCappuccino() {
        VendingMachine.start()
        val drink = getCappuccino()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Cappuccino")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    @Test
    fun testMaxCappuccino() {
        VendingMachine.start()
        val drink = getMaxCappuccino()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Cappuccino")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

}
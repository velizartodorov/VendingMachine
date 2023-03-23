package drinks.impl

import coin.Coin.TEN_CENTS
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType.CAPPUCCINO
import order.Status.DONE
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import vending_machine.TestHelper
import vending_machine.VendingMachine

internal class CappuccinoTest {
    @Test
    fun testCappuccino() {
        VendingMachine.start()
        val cappuccino = TestHelper.getCappuccino()
        val orderStatus = VendingMachine.prepare(cappuccino)
        Assertions.assertEquals(orderStatus.drink, CAPPUCCINO)
        Assertions.assertEquals(orderStatus.status, DONE)
        Assertions.assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    @Test
    fun testMaxCappuccino() {
        VendingMachine.start()
        val cappuccino = TestHelper.getMaxCappuccino()
        val orderStatus = VendingMachine.prepare(cappuccino)
        Assertions.assertEquals(orderStatus.drink, CAPPUCCINO)
        Assertions.assertEquals(orderStatus.status, DONE)
        Assertions.assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }
}
package drinks.impl

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
        Assertions.assertEquals(orderStatus.change, 30)
    }

    @Test
    fun testMaxCappuccino() {
        VendingMachine.start()
        val cappuccino = TestHelper.getMaxCappuccino()
        val orderStatus = VendingMachine.prepare(cappuccino)
        Assertions.assertEquals(orderStatus.drink, CAPPUCCINO)
        Assertions.assertEquals(orderStatus.status, DONE)
        Assertions.assertEquals(orderStatus.change, 30)
    }
}
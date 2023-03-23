package drinks.impl

import coin.Coin.TEN_CENTS
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType.AMERICANO
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import vending_machine.TestHelper
import vending_machine.VendingMachine
import kotlin.test.assertEquals

internal class AmericanoTest {
    @Test
    fun testOrderAmericano() {
        val americano = TestHelper.getAmericano()
        assertEquals(americano.drink, AMERICANO)
        assertEquals(americano.milk, NONE)
        assertEquals(americano.strength, MEDIUM)
        assertEquals(americano.sugar, NONE)
        assertEquals(americano.coins, listOf(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS))
    }

    @Test
    fun testVendingMachineWithAmericano() {
        VendingMachine.start()
        val americano = TestHelper.getAmericano()
        val orderStatus = VendingMachine.prepare(americano)
        Assertions.assertEquals(orderStatus.drink, AMERICANO)
        Assertions.assertEquals(orderStatus.status, DONE)
        Assertions.assertEquals(orderStatus.change, listOf(TEN_CENTS))
    }
}
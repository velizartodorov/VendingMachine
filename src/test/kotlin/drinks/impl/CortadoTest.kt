package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.CORTADO
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import vending_machine.TestHelper
import vending_machine.VendingMachine

internal class CortadoTest {

    @Test
    fun testOrderCortado() {
        val drink = TestHelper.getCortado()
        assertEquals(drink.drink, CORTADO)
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(FIFTY_CENTS))
    }

    @Test
    fun testVendingMachineWithCortado() {
        VendingMachine.start()
        val drink = TestHelper.getCortado()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, CORTADO)
        assertEquals(orderStatus.status, DONE)
        assertTrue(orderStatus.change.isEmpty())
    }

}
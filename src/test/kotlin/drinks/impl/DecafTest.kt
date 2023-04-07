package drinks.impl

import coin.Coin.ONE_EURO
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType.DECAF
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.TestHelper
import vending_machine.VendingMachine

internal class DecafTest {

    @Test
    fun testOrderDecaf() {
        val drink = TestHelper.getDecaf()
        assertEquals(drink.drink, DECAF)
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithDecaf() {
        VendingMachine.start()
        val drink = TestHelper.getDecaf()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, DECAF)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
    }

}
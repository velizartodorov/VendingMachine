package drinks.impl

import coin.Coin.ONE_EURO
import coin.Coin.TWENTY_CENTS
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class MochaTest : MochaTestHelper() {

    @Test
    fun testOrderMocha() {
        val drink = getMocha()
        assertEquals(drink.drink, "Mocha")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithMocha() {
        VendingMachine.start()
        val drink = getMocha()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Mocha")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TWENTY_CENTS))
        VendingMachine.stop()
    }

}
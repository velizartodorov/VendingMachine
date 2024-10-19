package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class IcedCoffeeTest : IcedCoffeeTestHelper() {
    @Test
    fun testOrderIcedCoffee() {
        val drink = getIcedCoffee()
        assertEquals(drink.drink, "IcedCoffee")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithIcedCoffee() {
        VendingMachine.start()
        val drink = getIcedCoffee()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "IcedCoffee")
        assertEquals(orderStatus.status, DONE)
        assertTrue(orderStatus.change.isEmpty())
        VendingMachine.stop()
    }

}
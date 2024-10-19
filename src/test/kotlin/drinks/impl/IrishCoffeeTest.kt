package drinks.impl

import coin.Coin.ONE_EURO
import coin.Coin.TEN_CENTS
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class IrishCoffeeTest : IrishCoffeeTestHelper() {

    @Test
    fun testOrderIrishCoffee() {
        val drink = irishCoffee
        assertEquals(drink.drink, "IrishCoffee")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithIrisCoffee() {
        VendingMachine.start()
        val drink = irishCoffee
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "IrishCoffee")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TEN_CENTS))
        VendingMachine.stop()
    }

}
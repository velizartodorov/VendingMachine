package drinks.impl

import coin.Coin.ONE_EURO
import coin.Coin.TWENTY_CENTS
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class DecafTest {

    @Test
    fun testOrderDecaf() {
        val drink = getDecaf()
        assertEquals(drink.drink, "Decaf")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithDecaf() {
        VendingMachine.start()
        val drink = getDecaf()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Decaf")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
    }

    private fun getDecaf() = Order.Builder()
        .drink("Decaf")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()

}
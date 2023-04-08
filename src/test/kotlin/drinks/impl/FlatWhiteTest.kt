package drinks.impl

import coin.Coin.*
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class FlatWhiteTest {
    @Test
    fun testOrderFlatWhite() {
        val drink = getFlatWhite()
        assertEquals(drink.drink, "FlatWhite")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithFlatWhite() {
        VendingMachine.start()
        val drink = getFlatWhite()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "FlatWhite")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    private fun getFlatWhite() =
        Order.Builder().drink("FlatWhite")
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO).build()
}
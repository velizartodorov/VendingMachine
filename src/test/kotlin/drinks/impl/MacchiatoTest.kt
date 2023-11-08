package drinks.impl

import coin.Coin.*
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class MacchiatoTest {
    @Test
    fun testOrderMacchiato() {
        val drink = getMacchiato()
        assertEquals(drink.drink, "Macchiato")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithMacchiato() {
        VendingMachine.start()
        val drink = getMacchiato()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Macchiato")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
        VendingMachine.stop()
    }

    private fun getMacchiato() = Order.Builder()
        .withDrink("Macchiato")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()
}
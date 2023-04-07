package drinks.impl

import coin.Coin.*
import drinks.DrinkType.MACCHIATO
import order.Amount.NONE
import order.Order
import order.Status
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class MacchiatoTest {
    @Test
    fun testOrderMacchiato() {
        val drink = getMacchiato()
        assertEquals(drink.drink, MACCHIATO)
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
        assertEquals(orderStatus.drink, MACCHIATO)
        assertEquals(orderStatus.status, Status.DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    private fun getMacchiato() = Order.Builder()
        .drink(MACCHIATO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()
}
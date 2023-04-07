package drinks.impl

import coin.Coin.*
import drinks.DrinkType.TEA
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class TeaTest {
    @Test
    fun testOrderTea() {
        val drink = getTea()
        assertEquals(drink.drink, TEA)
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithTea() {
        VendingMachine.start()
        val drink = getTea()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, TEA)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(FIFTY_CENTS, TWENTY_CENTS, TEN_CENTS, FIVE_CENTS))
    }

    private fun getTea() = Order.Builder()
        .drink(TEA)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()
}
package drinks.impl

import coin.Coin.ONE_EURO
import coin.Coin.TEN_CENTS
import drinks.DrinkType.IRISH_COFFEE
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class IrishCoffeeTest {
    @Test
    fun testOrderIrishCoffee() {
        val drink = getIrishCoffee()
        assertEquals(drink.drink, IRISH_COFFEE)
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(ONE_EURO))
    }

    @Test
    fun testVendingMachineWithIrisCoffee() {
        VendingMachine.start()
        val drink = getIrishCoffee()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, IRISH_COFFEE)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TEN_CENTS))
    }

    private fun getIrishCoffee() = Order.Builder()
        .drink(IRISH_COFFEE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()
}
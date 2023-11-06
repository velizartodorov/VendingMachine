package drinks.impl

import coin.Coin.FIFTY_CENTS
import coin.Coin.TWENTY_CENTS
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class LatteTest {

    @Test
    fun testOrderLatte() {
        val drink = getLatte()
        assertEquals(drink.drink, "Latte")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(FIFTY_CENTS))
    }

    @Test
    fun testVendingMachineWithLatte() {
        VendingMachine.start()
        val drink = getLatte()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Latte")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
        VendingMachine.stop()
    }

    @Test
    fun testVendingMachineWithSoftLatte() {
        VendingMachine.start()
        val drink = getSoftLatte()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Latte")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
    }

    @Test
    fun testVendingMachineWithStrongLatte() {
        VendingMachine.start()
        val drink = getStrongLatte()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Latte")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
    }

    private fun getLatte() = Order.Builder()
        .drink("Latte")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    private fun getSoftLatte() = Order.Builder()
        .drink("Latte")
        .withMilk(NONE)
        .withStrength(LOW)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    private fun getStrongLatte() = Order.Builder()
        .drink("Latte")
        .withMilk(NONE)
        .withStrength(HIGH)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

}
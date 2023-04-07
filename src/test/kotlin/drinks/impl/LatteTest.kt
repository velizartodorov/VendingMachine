package drinks.impl

import coin.Coin.FIFTY_CENTS
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType.LATTE
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.TestHelper.getLatte
import vending_machine.TestHelper.getSoftLatte
import vending_machine.TestHelper.getStrongLatte
import vending_machine.VendingMachine

internal class LatteTest {

    @Test
    fun testOrderLatte() {
        val drink = getLatte()
        assertEquals(drink.drink, LATTE)
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
        assertEquals(orderStatus.drink, LATTE)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
    }

    @Test
    fun testVendingMachineWithSoftLatte() {
        VendingMachine.start()
        val drink = getSoftLatte()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, LATTE)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
    }

    @Test
    fun testVendingMachineWithStrongLatte() {
        VendingMachine.start()
        val drink = getStrongLatte()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, LATTE)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS))
    }

}
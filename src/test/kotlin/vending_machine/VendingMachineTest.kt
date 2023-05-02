package vending_machine

import coin.Coin.FIFTY_CENTS
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import drinks.impl.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class VendingMachineTest {
    @Test
    fun testVendingMachineIsOn() {
        VendingMachine.start()
        assertTrue(VendingMachine.isOn())
        assertFalse(VendingMachine.isOff())
    }

    @Test
    fun testVendingMachineIsOff() {
        VendingMachine.stop()
        assertTrue(VendingMachine.isOff())
        assertFalse(VendingMachine.isOn())
    }

    @Test
    fun testVendingMachineTestRun() {
        VendingMachine.start()
    }

    @Test
    fun testVendingMachineWithNonExistingDrink() {
        VendingMachine.start()
        val nonExisting = getNonExistingDrink()
        assertThrows<NotImplementedException> { VendingMachine.prepare(nonExisting) }
    }

    private fun getNonExistingDrink() = Order.Builder()
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()
}
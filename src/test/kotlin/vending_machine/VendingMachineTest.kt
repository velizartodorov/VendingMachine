package vending_machine

import coin.Coin.FIFTY_CENTS
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class VendingMachineTest {

    @Test
    fun testVendingMachineIsOn() {
        VendingMachine.start()
        assertEquals(State.Running, VendingMachine.state)
        VendingMachine.stop()
    }

    @Test
    fun testVendingMachineIsOff() {
        VendingMachine.start()
        VendingMachine.stop()
        assertEquals(State.Stopped, VendingMachine.state)
    }

    @Test
    fun testVendingMachinePause() {
        VendingMachine.start()
        VendingMachine.pause()
        assertEquals(State.Paused, VendingMachine.state)
        VendingMachine.stop()
    }

    @Test
    fun testVendingMachineWithNonExistingDrink() {
        VendingMachine.start()
        val nonExisting = getNonExistingDrink()
        assertThrows<NotImplementedException> { VendingMachine.prepare(nonExisting) }
        VendingMachine.stop()
    }

    private fun getNonExistingDrink() = Order.Builder()
        .withMilk(NONE)
        .withWater(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()
}
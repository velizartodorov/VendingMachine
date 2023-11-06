package vending_machine

import coin.Coin.FIFTY_CENTS
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class VendingMachineTest {

    @BeforeEach
    fun startMachine() {
        VendingMachine.start()
    }

    @AfterEach
    fun stopMachine() {
        VendingMachine.stop()
    }

    @Test
    fun testVendingMachineIsOn() {
        VendingMachine.start()
        assertEquals(State.Running, VendingMachine.state)
    }

    @Test
    fun testVendingMachineIsOff() {
        VendingMachine.stop()
        assertEquals(State.Stopped, VendingMachine.state)
    }

    @Test
    fun testVendingMachinePause() {
        VendingMachine.pause()
        assertEquals(State.Paused, VendingMachine.state)
    }

    @Test
    fun testVendingMachineWithNonExistingDrink() {
        val nonExisting = getNonExistingDrink()
        assertThrows<NotImplementedException> { VendingMachine.prepare(nonExisting) }
    }

    private fun getNonExistingDrink() = Order.Builder()
        .withMilk(NONE)
        .withWater(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()
}
package vending_machine

import coin.Coin.FIFTY_CENTS
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation

@TestMethodOrder(OrderAnnotation::class)
internal class VendingMachineTest {

    @Test
    @org.junit.jupiter.api.Order(1)
    fun testVendingMachineStopFromIdle() {
        assertThrows<IllegalStateException>("Cannot stop when the vending machine is idle") {
            VendingMachine.stop()
        }
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    fun testVendingMachineStartsFromIdle() {
        assertThrows<IllegalStateException>("Cannot pause when the vending machine is idle") {
            VendingMachine.pause()
        }
    }

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
    fun testVendingMachineIsPaused() {
        VendingMachine.start()
        VendingMachine.pause()
        VendingMachine.pause()
        assertEquals(State.Paused, VendingMachine.state)
        VendingMachine.stop()
    }

    @Test
    fun testVendingMachineStartsTwice() {
        VendingMachine.start()
        VendingMachine.start()
        assertEquals(State.Running, VendingMachine.state)
        VendingMachine.stop()
    }

    @Test
    fun testVendingMachineStartsFromPausedState() {
        VendingMachine.start()
        VendingMachine.pause()
        assertThrows<IllegalStateException>("Cannot start from a stopped state") {
            VendingMachine.start()
        }
        VendingMachine.stop()
    }

    @Test
    fun testPauseVendingMachineStartsFromStoppedState() {
        VendingMachine.start()
        VendingMachine.stop()
        assertThrows<IllegalStateException>("Cannot pause when the vending machine is stopped") {
            VendingMachine.pause()
        }
    }

    @Test
    fun testVendingMachineStopFromStoppedState() {
        VendingMachine.start()
        VendingMachine.stop()
        assertThrows<IllegalStateException>("Cannot pause when the vending machine is stopped") {
            VendingMachine.stop()
        }
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
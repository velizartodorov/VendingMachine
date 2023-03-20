package vending_machine

import jdk.jshell.spi.ExecutionControl.NotImplementedException
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
        VendingMachine.testRun()
    }

    @Test
    fun testVendingMachineWithAmericano() {
        VendingMachine.start()
        val americano = DrinkHelper.getAmericano()
        VendingMachine.prepare(americano)
    }

    @Test
    fun testVendingMachineWithNonExistingDrink() {
        VendingMachine.start()
        val nonExisting = DrinkHelper.getNonExistingDrink()
        assertThrows<NotImplementedException> { VendingMachine.prepare(nonExisting) }
    }
}
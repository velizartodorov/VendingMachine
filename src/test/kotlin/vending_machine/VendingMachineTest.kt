package vending_machine

import drinks.DrinkType.AMERICANO
import drinks.DrinkType.LATTE
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Status.DONE
import org.junit.jupiter.api.Assertions.*
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
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, AMERICANO)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, 10)
    }

    @Test
    fun testVendingMachineWithLatte() {
        VendingMachine.start()
        val americano = DrinkHelper.getLatte()
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, LATTE)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, 20)
    }

    @Test
    fun testVendingMachineWithNonExistingDrink() {
        VendingMachine.start()
        val nonExisting = DrinkHelper.getNonExistingDrink()
        assertThrows<NotImplementedException> { VendingMachine.prepare(nonExisting) }
    }
}
package vending_machine

import drinks.DrinkType.*
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
        val americano = TestHelper.getAmericano()
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, AMERICANO)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, 10)
    }

    @Test
    fun testVendingMachineWithLatte() {
        VendingMachine.start()
        val americano = TestHelper.getLatte()
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, LATTE)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, 20)
    }

    @Test
    fun testVendingMachineWithSoftLatte() {
        VendingMachine.start()
        val americano = TestHelper.getSoftLatte()
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, LATTE)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, 20)
    }

    @Test
    fun testCappuccino() {
        VendingMachine.start()
        val cappuccino = TestHelper.getCappuccino()
        val orderStatus = VendingMachine.prepare(cappuccino)
        assertEquals(orderStatus.drink, CAPPUCCINO)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, 30)
    }

    @Test
    fun testVendingMachineWithNonExistingDrink() {
        VendingMachine.start()
        val nonExisting = TestHelper.getNonExistingDrink()
        assertThrows<NotImplementedException> { VendingMachine.prepare(nonExisting) }
    }
}
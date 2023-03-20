package vending_machine

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class VendingMachineTest {
    @Test
    fun testVendingMachineOn() {
        VendingMachine.start()
        assertTrue(VendingMachine.isOn())
        assertFalse(VendingMachine.isOff())
    }

    @Test
    fun testVendingMachineOff() {
        VendingMachine.stop()
        assertTrue(VendingMachine.isOff())
        assertFalse(VendingMachine.isOn())
    }
}
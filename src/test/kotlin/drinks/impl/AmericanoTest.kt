package drinks.impl

import coin.Coin.TEN_CENTS
import coin.Coin.TWENTY_CENTS
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

class AmericanoTest : AmericanoTestHelper() {
    @Test
    fun testOrderAmericano() {
        val americano = getAmericano()
        assertEquals(americano.drink, "Americano")
        assertEquals(americano.milk, NONE)
        assertEquals(americano.strength, MEDIUM)
        assertEquals(americano.sugar, NONE)
        assertEquals(
            americano.coins,
            listOf(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS)
        )
    }

    @Test
    fun testVendingMachineWithAmericano() {
        VendingMachine.start()
        val americano = getAmericano()
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, "Americano")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
        VendingMachine.stop()
    }

}
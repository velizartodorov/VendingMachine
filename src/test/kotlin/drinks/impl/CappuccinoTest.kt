package drinks.impl

import coin.Coin
import coin.Coin.TEN_CENTS
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType.CAPPUCCINO
import order.Amount
import order.Order
import order.Status.DONE
import order.Strength
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class CappuccinoTest {
    @Test
    fun testCappuccino() {
        VendingMachine.start()
        val drink = getCappuccino()
        val orderStatus = VendingMachine.prepare(drink)
        Assertions.assertEquals(orderStatus.drink, CAPPUCCINO)
        Assertions.assertEquals(orderStatus.status, DONE)
        Assertions.assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    @Test
    fun testMaxCappuccino() {
        VendingMachine.start()
        val drink = getMaxCappuccino()
        val orderStatus = VendingMachine.prepare(drink)
        Assertions.assertEquals(orderStatus.drink, CAPPUCCINO)
        Assertions.assertEquals(orderStatus.status, DONE)
        Assertions.assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    private fun getCappuccino() = Order.Builder()
        .drink(CAPPUCCINO)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(Coin.FIFTY_CENTS)
        .build()

    private fun getMaxCappuccino() = Order.Builder()
        .drink(CAPPUCCINO)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MAX)
        .withSugar(Amount.NONE)
        .withCoins(Coin.FIFTY_CENTS)
        .build()
}
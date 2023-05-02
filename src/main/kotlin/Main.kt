import coin.Coin.TWENTY_CENTS
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import vending_machine.VendingMachine
import vending_machine.Interface

fun main() {
    VendingMachine.start()
    VendingMachine.stop()

    Interface.printDrinks()

    val drinkNumber = readLine()!!.toInt()

    val drinkName = Interface.getDrink(drinkNumber)

    val order = Order.Builder()
        .drink(drinkName)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS)
        .build()

    VendingMachine.prepare(order)
}


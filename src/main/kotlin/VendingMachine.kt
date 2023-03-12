import drinks.DrinkService
import drinks.DrinkType
import drinks.DrinkType.DECAF
import drinks.DrinkType.IRISH_COFFEE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import vending_machine.Power

fun main() {
    start()
    orderLatte()
    orderCappuccino()
    orderCortado()
    orderTea()
    orderEspresso()
    orderMocha()
    orderMacchiato()
    orderFlatWhite()
    orderDecaf()
    orderIrishCoffee()
    stop()
}

private var power: Power = Power.OFF

fun start() {
    println("Starting vending machine ...")
    println("Vending machine is ON.")
    power = Power.ON
}

fun orderLatte() {
    val latte = Order.Builder()
        .drink(DrinkType.LATTE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(30)
        .build()
    DrinkService.order(latte)
}

fun orderCappuccino() {
    val cappuccino = Order.Builder()
        .drink(DrinkType.CAPPUCCINO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(30)
        .build()
    DrinkService.order(cappuccino)
}

fun orderCortado() {
    val cortado = Order.Builder()
        .drink(DrinkType.CORTADO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(50)
        .build()
    DrinkService.order(cortado)
}

fun orderTea() {
    val tea = Order.Builder()
        .drink(DrinkType.TEA)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(20)
        .build()
    DrinkService.order(tea)
}

fun orderEspresso() {
    val espresso = Order.Builder()
        .drink(DrinkType.ESPRESSO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(25)
        .build()
    DrinkService.order(espresso)
}

fun orderMocha() {
    val mocha = Order.Builder()
        .drink(DrinkType.MOCHA)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(60)
        .build()
    DrinkService.order(mocha)
}

fun orderMacchiato() {
    val macchiato = Order.Builder()
        .drink(DrinkType.MACCHIATO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(80)
        .build()
    DrinkService.order(macchiato)
}

fun orderFlatWhite() {
    val flatWhite = Order.Builder()
        .drink(DrinkType.FLAT_WHITE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(80)
        .build()
    DrinkService.order(flatWhite)
}

fun orderDecaf() {
    val decaf = Order.Builder()
        .drink(DECAF)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(90)
        .build()
    DrinkService.order(decaf)
}

fun orderIrishCoffee() {
    val irishCoffee = Order.Builder()
        .drink(IRISH_COFFEE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(90)
        .build()
    DrinkService.order(irishCoffee)
}

fun stop() {
    println("Stopping vending machine ...")
    println("Vending machine is OFF.")
    power = Power.OFF
}
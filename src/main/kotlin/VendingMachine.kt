import drinks.DrinkService
import drinks.DrinkType
import order.Amount
import order.Order
import order.Strength
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
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(30)
        .build()
    DrinkService.order(latte)
}

fun orderCappuccino() {
    val cappuccino = Order.Builder()
        .drink(DrinkType.CAPPUCCINO)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(30)
        .build()
    DrinkService.order(cappuccino)
}

fun orderCortado() {
    val cortado = Order.Builder()
        .drink(DrinkType.CORTADO)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(50)
        .build()
    DrinkService.order(cortado)
}

fun orderTea() {
    val tea = Order.Builder()
        .drink(DrinkType.TEA)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(20)
        .build()
    DrinkService.order(tea)
}

fun orderEspresso() {
    val espresso = Order.Builder()
        .drink(DrinkType.ESPRESSO)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(25)
        .build()
    DrinkService.order(espresso)
}

fun orderMocha() {
    val mocha = Order.Builder()
        .drink(DrinkType.MOCHA)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(60)
        .build()
    DrinkService.order(mocha)
}

fun orderMacchiato() {
    val macchiato = Order.Builder()
        .drink(DrinkType.MACCHIATO)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(80)
        .build()
    DrinkService.order(macchiato)
}

fun orderFlatWhite() {
    val flatWhite = Order.Builder()
        .drink(DrinkType.FLAT_WHITE)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(80)
        .build()
    DrinkService.order(flatWhite)
}

fun orderDecaf() {
    val decaf = Order.Builder()
        .drink(DrinkType.DECAF)
        .withMilk(Amount.NONE)
        .withStrength(Strength.MEDIUM)
        .withSugar(Amount.NONE)
        .withCoins(80)
        .build()
    DrinkService.order(decaf)
}

fun stop() {
    println("Stopping vending machine ...")
    println("Vending machine is OFF.")
    power = Power.OFF
}
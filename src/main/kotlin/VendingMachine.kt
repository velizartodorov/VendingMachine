import drinks.DrinkService
import drinks.DrinkType.*
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import vending_machine.Power
import vending_machine.Power.OFF
import vending_machine.Power.ON

fun main() {
    start()
    orderLatte()
    orderCappuccino()
    orderAmericano()
    orderCortado()
    orderTea()
    orderEspresso()
    orderMocha()
    orderMacchiato()
    orderFlatWhite()
    orderDecaf()
    orderIrishCoffee()
    orderIcedCoffee()
    orderCafeAuLait()
    orderWater()
    stop()
}

private var power: Power = OFF

fun start() {
    println("Starting vending machine ...")
    println("Vending machine is ON.")
    power = ON
}

fun orderLatte() {
    val latte = Order.Builder()
        .drink(LATTE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(30)
        .build()
    DrinkService.order(latte)
}

fun orderCappuccino() {
    val cappuccino = Order.Builder()
        .drink(CAPPUCCINO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(30)
        .build()
    DrinkService.order(cappuccino)
}

fun orderAmericano() {
    val americano = Order.Builder()
        .drink(AMERICANO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(50)
        .build()
    DrinkService.order(americano)
}

fun orderCortado() {
    val cortado = Order.Builder()
        .drink(CORTADO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(50)
        .build()
    DrinkService.order(cortado)
}

fun orderTea() {
    val tea = Order.Builder()
        .drink(TEA)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(20)
        .build()
    DrinkService.order(tea)
}

fun orderEspresso() {
    val espresso = Order.Builder()
        .drink(ESPRESSO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(25)
        .build()
    DrinkService.order(espresso)
}

fun orderMocha() {
    val mocha = Order.Builder()
        .drink(MOCHA)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(60)
        .build()
    DrinkService.order(mocha)
}

fun orderMacchiato() {
    val macchiato = Order.Builder()
        .drink(MACCHIATO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(80)
        .build()
    DrinkService.order(macchiato)
}

fun orderFlatWhite() {
    val flatWhite = Order.Builder()
        .drink(FLAT_WHITE)
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

fun orderIcedCoffee() {
    val icedCoffee = Order.Builder()
        .drink(ICED_COFFEE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(100)
        .build()
    DrinkService.order(icedCoffee)
}

fun orderCafeAuLait() {
    val cafeAuLait = Order.Builder()
        .drink(CAFE_AU_LAIT)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(110)
        .build()
    DrinkService.order(cafeAuLait)
}

fun orderWater() {
    val cafeAuLait = Order.Builder()
        .drink(WATER)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(110)
        .build()
    DrinkService.order(cafeAuLait)
}

fun stop() {
    println("Stopping vending machine ...")
    println("Vending machine is OFF.")
    power = OFF
}
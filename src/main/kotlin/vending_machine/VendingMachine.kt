package vending_machine

import drinks.DrinkService
import drinks.DrinkType.*
import order.Amount.NONE
import order.Order
import order.Strength
import vending_machine.Power.OFF
import vending_machine.Power.ON

object VendingMachine {
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
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        DrinkService.order(latte)
    }

    fun orderCappuccino() {
        val cappuccino = Order.Builder()
            .drink(CAPPUCCINO)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        DrinkService.order(cappuccino)
    }

    fun orderCortado() {
        val cortado = Order.Builder()
            .drink(CORTADO)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(50)
            .build()
        DrinkService.order(cortado)
    }

    fun orderTea() {
        val tea = Order.Builder()
            .drink(TEA)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(20)
            .build()
        DrinkService.order(tea)
    }

    fun orderEspresso() {
        val espresso = Order.Builder()
            .drink(ESPRESSO)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(25)
            .build()
        DrinkService.order(espresso)
    }

    fun orderMocha() {
        val mocha = Order.Builder()
            .drink(MOCHA)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(60)
            .build()
        DrinkService.order(mocha)
    }

    fun orderMacchiato() {
        val macchiato = Order.Builder()
            .drink(MACCHIATO)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(80)
            .build()
        DrinkService.order(macchiato)
    }

    fun orderFlatWhite() {
        val flatWhite = Order.Builder()
            .drink(FLAT_WHITE)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(80)
            .build()
        DrinkService.order(flatWhite)
    }

    fun stop() {
        println("Stopping vending machine ...")
        println("Vending machine is OFF.")
        power = OFF
    }

}
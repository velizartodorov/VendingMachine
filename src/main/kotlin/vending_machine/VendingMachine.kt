package vending_machine

import drinks.DrinkEnum.*
import drinks.DrinkService
import order.Amount.MEDIUM
import order.Amount.NONE
import order.Order
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
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        DrinkService.order(latte);
    }

    fun orderCappuccino() {
        val cappuccino = Order.Builder()
            .drink(CAPPUCCINO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        DrinkService.order(cappuccino);
    }

    fun orderTea() {
        val tea = Order.Builder()
            .drink(TEA)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(20)
            .build()
        println(tea.toString())
    }

    fun stop() {
        println("Stopping vending machine ...")
        println("Vending machine is OFF.")
        power = OFF
    }

}
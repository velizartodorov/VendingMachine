package vending_machine

import order.Amount.MEDIUM
import order.Amount.NONE
import order.Drink.TEA
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

    fun orderTea() {
        val tea = Order.Builder()
            .drink(TEA)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withPrice(20)
            .order()
        println(tea.toString())
    }

    fun stop() {
        println("Stopping vending machine ...")
        println("Vending machine is OFF.")
        power = OFF
    }

}
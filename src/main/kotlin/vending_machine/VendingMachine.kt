package vending_machine

import drinks.impl.Drink
import order.Order
import order.OrderResponse
import vending_machine.Power.OFF
import vending_machine.Power.ON
import vending_machine.intefaces.UserInterface

object VendingMachine {
    private var power: Power = OFF

    fun isOn(): Boolean {
        return power == ON
    }

    fun isOff(): Boolean {
        return power == OFF
    }

    fun start() {
        println("Starting vending machine ...")
        println("Vending machine is ON.")
        power = ON
    }

    fun run() {
        val order = Order.Builder().build()
        UserInterface.getAll().forEach { userInterface ->
            userInterface.print()
            userInterface.process(order)
        }
        prepare(order)
    }

    fun prepare(order: Order): OrderResponse {
        return Drink.getDrink(order.drink).prepare(order)
    }

    fun stop() {
        println("Stopping vending machine ...")
        println("Vending machine is OFF.")
        power = OFF
    }

}
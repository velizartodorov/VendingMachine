package vending_machine

import coin.Coin.TWENTY_CENTS
import drinks.impl.Drink
import order.Order
import order.OrderResponse
import vending_machine.Power.OFF
import vending_machine.Power.ON
import vending_machine.intefaces.DrinkInterface
import vending_machine.intefaces.MilkInterface
import vending_machine.intefaces.StrengthInterface
import vending_machine.intefaces.SugarInterface

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
        DrinkInterface.print()
        val drinkName = DrinkInterface.get(readLine()!!.toInt())

        StrengthInterface.print()
        val strength = StrengthInterface.get(readLine()!!.toInt())

        MilkInterface.print()
        val milk = MilkInterface.get(readLine()!!.toInt())

        SugarInterface.print()
        val sugar = SugarInterface.get(readLine()!!.toInt())

        val order = Order.Builder()
            .drink(drinkName)
            .withMilk(milk)
            .withStrength(strength)
            .withSugar(sugar)
            .withCoins(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS)
            .build()

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
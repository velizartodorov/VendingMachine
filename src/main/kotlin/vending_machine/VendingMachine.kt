package vending_machine

import drinks.DrinkType
import drinks.impl.Drink
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Order
import vending_machine.Power.OFF
import vending_machine.Power.ON
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

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

    fun stop() {
        println("Stopping vending machine ...")
        println("Vending machine is OFF.")
        power = OFF
    }

    fun testRun() {
        val drinks = Drink::class.sealedSubclasses
        for (drinkClass: KClass<out Drink> in drinks) {
            val drink = drinkClass.createInstance()
            drink.prepareTestOrder()
        }
    }

    fun prepare(order: Order) {
        getDrink(order.drink).prepare(order)
    }

    private fun getDrink(drinkType: DrinkType?): Drink {
        val drinks = Drink::class.sealedSubclasses
        for (drinkClass: KClass<out Drink> in drinks) {
            val drink: Drink = drinkClass.createInstance()
            if (drink.name() == drinkType) return drink
        }
        throw NotImplementedException("Drink doesn't exist: $drinkType")
    }
}
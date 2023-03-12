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
            val order = drinkClass.createInstance().testOrder()
            prepare(order)
        }
    }

    private fun prepare(order: Order) {
        val drink = getDrink(order.drink)
        if (order.coins!! >= drink.price()) drink.prepare() else {
            throw IllegalArgumentException(getErrorMessage(drink, order))
        }
    }

    private fun getErrorMessage(drink: Drink, order: Order) =
        "Amount insufficient for ${drink.name()}! " +
                "Needed amount: ${drink.price()} " +
                "Current amount: ${order.coins}"

    private fun getDrink(drinkType: DrinkType?): Drink {
        val drinks = Drink::class.sealedSubclasses
        for (drinkClass: KClass<out Drink> in drinks) {
            val drink: Drink = drinkClass.createInstance()
            if (drink.name() == drinkType) return drink
        }
        throw NotImplementedException("Drink doesn't exist: $drinkType")
    }
}
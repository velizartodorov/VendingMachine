import drinks.DrinkService
import vending_machine.Power
import vending_machine.Power.OFF
import vending_machine.Power.ON

fun main() {
    start()
    DrinkService.testRun()
    stop()
}

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
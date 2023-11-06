package vending_machine

import drinks.impl.Drink
import order.Order
import order.OrderResponse
import vending_machine.intefaces.UserInterface

object VendingMachine {
    var state: State = State.Idle

    fun start() {
        when (state) {
            is State.Idle, is State.Stopped -> {
                state = State.Running
                println("Started the vending machine")
            }
            is State.Running -> {
                println("Vending machine is running")
            }
            is State.Paused -> {
                throw IllegalStateException("Cannot start from a paused state")
            }
        }
    }

    fun pause() {
        when (state) {
            is State.Running -> {
                state = State.Paused
                println("Paused the vending machine")
            }
            is State.Idle -> {
                throw IllegalStateException("Cannot pause when the vending machine is idle")
            }
            is State.Paused -> {
                println("The vending machine is already paused")
            }
            is State.Stopped -> {
                throw IllegalStateException("Cannot pause when the vending machine is stopped")
            }
        }
    }

    fun selectDrink() {
        UserInterface.printLabel()
        UserInterface.selectDrink()
    }

    fun prepare(order: Order): OrderResponse {
        return Drink.getDrink(order.drink).prepare(order)
    }

    fun stop() {
        when (state) {
            is State.Running, is State.Paused -> {
                state = State.Stopped
                println("Stopped the vending machine")
            }
            is State.Idle -> {
                throw IllegalStateException("Cannot stop when the vending machine is idle")
            }
            is State.Stopped -> {
                throw IllegalStateException("The vending machine is already stopped")
            }
        }
    }
}
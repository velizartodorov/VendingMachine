package vending_machine

sealed class State {
    object Idle : State()
    object Running : State()
    object Paused : State()
    object Stopped : State()
}
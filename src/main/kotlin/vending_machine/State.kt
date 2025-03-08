package vending_machine

sealed class State {
    data object Idle : State()
    data object Running : State()
    data object Paused : State()
    data object Stopped : State()
}
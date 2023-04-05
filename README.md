# Vending Machine

<img src="assets/vending_machine.png" width="250">

Building a vending machine in Kotlin because ... why not? 🙂

## How to start? 🤔

1. Make sure you have [azul-13-sdk](https://www.azul.com/downloads/?package=jdk)
   installed for Kotlin.
2. Go to [Main.kt](src/main/kotlin/Main.kt) and run the `fun main()` function.

## Building & testing ✅

When a new commit is pushed, a [GitHub Actions](https://github.com/features/actions) pipeline is
triggered.
<br>This is acquired by the [build.yml](.github/workflows/build.yml)
and [tests.yml](.github/workflows/tests.yml) files. Example:

<img src="assets/github_actions.png" width="450">

## Implementation 🔧

### Functionality ✨

The vending machine works with list of coins and can also return change. 🧙‍

For now this basic implementation supports the following types of drinks:

* Americano
* Café Au Lait
* Cappuccino
* Cortado
* Decaf
* Drink
* Espresso
* Flat White
* Iced Coffee
* Irish Coffee
* Latte
* Macchiato
* Mocha
* Tea
* Water

### Architecture ⚙️

#### Choice of drink 🍶

The choice of a drink is based
on [Factory Pattern](https://en.wikipedia.org/wiki/Factory_(object-oriented_programming)). All the
drinks implement the abstract sealed class `Drink` and inherit it. with the help
of [sealed classes](https://kotlinlang.org/docs/sealed-classes.html) in Kotlin, we can avoid the use
of pattern matching/`switch`/`if...else` statements and can autoload new implementations.

#### Choice of container 📥📤

The choice of a container is based
on [Factory Pattern](https://en.wikipedia.org/wiki/Factory_(object-oriented_programming)). For now
there are a few containers - water, beans, tea, milk and sugar. When a certain container is chosen,
the amount in the container itself decreases.
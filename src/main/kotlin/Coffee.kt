package org.example

sealed class Coffee(
    open val countSugar: Int,
    open val volume: Int
) {
    class Americano(
        override val countSugar: Int,
        override val volume: Int
    ) : Coffee(countSugar, volume) {
        override fun toString(): String {
            return "Americano, сахар: $countSugar, объем: $volume мл."
        }
    }

    class Cappuccino(
        override val countSugar: Int,
        override val volume: Int,
        private val milk: Int
    ) : Coffee(countSugar, volume) {
        override fun toString(): String {
            return "Cappuccino, сахар: $countSugar, объем: $volume мл, молока: $milk мл."
        }
    }

    class Latte(
        override val countSugar: Int,
        override val volume: Int
    ) : Coffee(countSugar, volume) {
        override fun toString(): String {
            return "Latte, сахар: $countSugar, объем: $volume мл."
        }
    }
}
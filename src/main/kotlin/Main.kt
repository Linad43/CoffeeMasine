package org.example

import kotlinx.coroutines.delay

suspend fun main() {
    println("Кофе - машина")
    while (true) {
        println("Выберите кофе:")
        println("1.Americano")
        println("2.Cappuccino")
        println("3.Latte")
        println("0.Выход")
        val choice = readln()

        when (choice) {
            "1" -> {
                val (sugar, volume) = adding()
                val americano = Coffee.Americano(sugar, volume)
                selectedMenu(americano)
            }

            "2" -> {
                val (sugar, volume) = adding()
                val milk = addMilk()
                val cappuccino = Coffee.Cappuccino(sugar, volume, milk)
                selectedMenu(cappuccino)
            }

            "3" -> {
                val (sugar, volume) = adding()
                val latte = Coffee.Latte(sugar, volume)
                selectedMenu(latte)
            }

            else -> break
        }
    }
}

private suspend fun selectedMenu(menu: Coffee) {
    reading(menu.volume)
    println()
    println("Ваш кофе готов: $menu")
}

private suspend fun reading(volume: Int) {
    for (i in 1..10) {
        delay(volume.toLong())
        print("${i * 10}% ")
    }

}

private fun adding(): Pair<Int, Int> {
    val sugar = addSugar()
    val volume = addVolume()
    return Pair(sugar, volume)
}

private fun addSugar(): Int {
    var sugar: Int
    do {
        print("Количество сахара: ")
        sugar = readln().toInt()
        if (sugar < 0 || sugar > 10) {
            println("Сахара не может быть меньше 0 и больше 10")
            continue
        }
        break
    } while (true)
    return sugar
}

private fun addVolume(): Int {
    var volume: Int
    do {
        print("Объем кофе(мл): ")
        volume = readln().toInt()
        if (volume < 0 || volume > 1000) {
            println("Объем кофе не может быть меньше 0 и больше 1000 мл")
            continue
        }
        break
    } while (true)
    return volume
}

private fun addMilk(): Int {
    var milk: Int
    do {
        print("Объем молока(мл): ")
        milk = readln().toInt()
        if (milk < 0 || milk > 1000) {
            println("Объем молока не может быть меньше 0 и больше 1000 мл")
            continue
        }
        break
    } while (true)
    return milk
}
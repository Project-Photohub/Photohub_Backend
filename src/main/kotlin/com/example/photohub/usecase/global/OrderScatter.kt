package com.example.photohub.usecase.global

import java.time.LocalTime
import kotlin.random.Random

object OrderScatter {

    operator fun <T> invoke(argsList: List<T>): List<T> {
        val list = argsList.toMutableList()
        val size = list.size

        val random = Random(LocalTime.now().nano)

        list.forEachIndexed { index, it ->
            if (size - 1 == index) {
                return@forEachIndexed
            }

            if (random.nextBoolean()) {
                val temp = list[index]
                list[index] = list[index + 1]
                list[index + 1] = temp
            }
        }

        return list
    }
}
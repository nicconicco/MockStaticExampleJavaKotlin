package com.nicco.mockstaticsexamples

import java.util.*

class MyUselessUtils {

    fun fuu() = "Hello world"

    companion object {
        fun generateUUID() = UUID.randomUUID().toString()
    }
}
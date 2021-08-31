package com.nicco.mockstaticsexamples

import java.util.*

class MyDumbUtils {

    fun fuu() = "Hello world"

    companion object {
        fun generateUUID() = UUID.randomUUID().toString()
    }
}
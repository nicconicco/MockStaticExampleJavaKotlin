package com.nicco.mockstaticsexamples

class Util {
    fun ok() {
        UtilJava.ok()
        UtilKotlin.ok()
    }

    fun callMyUselessUtils(): String {
        return MyUselessUtils.generateUUID()
    }
}
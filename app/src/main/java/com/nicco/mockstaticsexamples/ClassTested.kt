package com.nicco.mockstaticsexamples

class ClassTested {
    fun ok() {
        UtilJava.ok()
        UtilKotlin.ok()
    }

    fun callMyDumbUtils(): String {
        return MyDumbUtils.generateUUID()
    }
}
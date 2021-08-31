package com.nicco.mockstaticsexamples

import io.mockk.*
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class NiccoUtils {

    @Test
    fun ok() {
        val util = ClassTested()
        mockkStatic(UtilJava::class)
        mockkObject(UtilKotlin)

        every { UtilJava.ok() } returns "Carlos"
        every { UtilKotlin.ok() } returns "Galves"

        util.ok()

        verify { UtilJava.ok() }
        verify { UtilKotlin.ok() }

        assertEquals("Carlos", UtilJava.ok())
        assertEquals("Galves", UtilKotlin.ok())
    }

    @Test
    fun another_test(){
        val uuid = "1234"
        mockkObject(MyDumbUtils)
        every { MyDumbUtils.generateUUID() } returns uuid

        val util = ClassTested()
        val result= util.callMyDumbUtils()
        assertTrue(result=="1234")

        unmockkObject(MyDumbUtils)
    }

    @Test
    fun test_thirty_party(){
        val myCallerSDKController = MyCallerSDKController()
        mockkStatic(SDKThirtyParty::class)
        every { SDKThirtyParty.getInstance() } returns "LeroLero"

        val result = myCallerSDKController.callThirtyPartySDK()

        verify { SDKThirtyParty.getInstance() }
        assertEquals("LeroLero", result)
    }
}
package com.nicco.mockstaticsexamples

import io.mockk.*
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class UtilTest {

    @Test
    fun ok() {
        val util = Util()
        mockkStatic(UtilJava::class)
        mockkObject(UtilKotlin)

        every { UtilJava.ok() } returns "Joe"
        every { UtilKotlin.ok() } returns "Tsai"

        util.ok()

        verify { UtilJava.ok() }
        verify { UtilKotlin.ok() }

        assertEquals("Joe", UtilJava.ok())
        assertEquals("Tsai", UtilKotlin.ok())
    }

    @Test
    fun another_test(){
        val uuid = "1234"
        mockkObject(MyUselessUtils)
        every { MyUselessUtils.generateUUID() } returns uuid

        val util = Util()
        val result= util.callMyUselessUtils()
        assertTrue(result=="1234")

        unmockkObject(MyUselessUtils)
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